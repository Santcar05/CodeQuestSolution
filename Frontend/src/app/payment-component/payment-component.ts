import { Component, OnInit } from '@angular/core';
import { loadStripe, Stripe } from '@stripe/stripe-js';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { environment } from '../../../environment';

const PK_STRIPE = environment.pkStripe;

@Component({
  selector: 'app-payment',
  templateUrl: './payment-component.html',
  styleUrls: ['./payment-component.css'],
  standalone: true,
  imports: [HttpClientModule, CommonModule],
})
export class PaymentComponent implements OnInit {
  stripePromise = loadStripe(PK_STRIPE!);
  stripe!: Stripe | null;
  cardElement: any;

  processing = false;
  paymentSuccess = false;

  constructor(private http: HttpClient) {}

  async ngOnInit() {
    this.stripe = await this.stripePromise;

    if (this.stripe) {
      const elements = this.stripe.elements();
      this.cardElement = elements.create('card', {
        style: {
          base: {
            color: '#ffffff',
            fontFamily: '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
            fontSize: '16px',
            '::placeholder': { color: '#64748b' },
            iconColor: '#ff5a00',
          },
          invalid: { color: '#ef4444', iconColor: '#ef4444' },
        },
      });

      this.cardElement.mount('#card-element');

      this.cardElement.on('focus', () =>
        document.querySelector('.stripe-card-element')?.classList.add('StripeElement--focus')
      );
      this.cardElement.on('blur', () =>
        document.querySelector('.stripe-card-element')?.classList.remove('StripeElement--focus')
      );
    }
  }

  async pay() {
    if (this.processing) return;
    this.processing = true;

    try {
      const formValid = this.validateForm();
      if (!formValid) {
        this.processing = false;
        return;
      }

      const resp: any = await this.http
        .post('http://localhost:8080/api/payments/create-payment-intent', {
          amount: 500, // $50.00 USD
          currency: 'usd', // 'cop', 'eur', etc.
        })
        .toPromise();

      const clientSecret = resp.clientSecret;
      const result = await this.stripe!.confirmCardPayment(clientSecret, {
        payment_method: {
          card: this.cardElement,
          billing_details: {
            name: this.getCustomerName(),
            email: this.getCustomerEmail(),
          },
        },
      });

      if (result.error) {
        alert(`Error en el pago: ${result.error.message}`);
      } else if (result.paymentIntent?.status === 'succeeded') {
        this.paymentSuccess = true;
      }
    } catch (error) {
      alert('Ocurrió un error durante el proceso de pago.');
      console.error(error);
    } finally {
      this.processing = false;
    }
  }

  validateForm(): boolean {
    return true;
  }

  getCustomerName(): string {
    const nameInput = document.querySelector(
      'input[placeholder="Ingresa tu nombre completo"]'
    ) as HTMLInputElement;
    return nameInput?.value || 'Cliente';
  }

  getCustomerEmail(): string {
    const emailInput = document.querySelector('input[type="email"]') as HTMLInputElement;
    return emailInput?.value || 'cliente@email.com';
  }

  closeModal() {
    this.paymentSuccess = false;
  }
}
