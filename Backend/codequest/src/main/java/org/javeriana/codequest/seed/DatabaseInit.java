package org.javeriana.codequest.seed;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.javeriana.codequest.entity.Achievement;
import org.javeriana.codequest.entity.Badge;
import org.javeriana.codequest.entity.CareerPath;
import org.javeriana.codequest.entity.Challenge;
import org.javeriana.codequest.entity.ChatMessage;
import org.javeriana.codequest.entity.CodeExplanation;
import org.javeriana.codequest.entity.Course;
import org.javeriana.codequest.entity.ExamResults;
import org.javeriana.codequest.entity.FeaturedUser;
import org.javeriana.codequest.entity.Instructor;
import org.javeriana.codequest.entity.LearningMethod;
import org.javeriana.codequest.entity.Lesson;
import org.javeriana.codequest.entity.LessonContent;
import org.javeriana.codequest.entity.MenuItem;
import org.javeriana.codequest.entity.ModuleModel;
import org.javeriana.codequest.entity.OptionForm;
import org.javeriana.codequest.entity.Post;
import org.javeriana.codequest.entity.Power;
import org.javeriana.codequest.entity.PremiumPlan;
import org.javeriana.codequest.entity.Product;
import org.javeriana.codequest.entity.Project;
import org.javeriana.codequest.entity.Question;
import org.javeriana.codequest.entity.QuestionForm;
import org.javeriana.codequest.entity.Requirement;
import org.javeriana.codequest.entity.ResourceModel;
import org.javeriana.codequest.entity.Skill;
import org.javeriana.codequest.entity.Technology;
import org.javeriana.codequest.entity.TestCase;
import org.javeriana.codequest.entity.Topic;
import org.javeriana.codequest.entity.Trend;
import org.javeriana.codequest.entity.UserProfile;
import org.javeriana.codequest.service.entity.AchievementService;
import org.javeriana.codequest.service.entity.BadgeService;
import org.javeriana.codequest.service.entity.CareerPathService;
import org.javeriana.codequest.service.entity.ChallengeService;
import org.javeriana.codequest.service.entity.ChatMessageService;
import org.javeriana.codequest.service.entity.CodeExplanationService;
import org.javeriana.codequest.service.entity.CommentModelService;
import org.javeriana.codequest.service.entity.CourseService;
import org.javeriana.codequest.service.entity.ExamResultsService;
import org.javeriana.codequest.service.entity.FeaturedUserService;
import org.javeriana.codequest.service.entity.InstructorService;
import org.javeriana.codequest.service.entity.LearningMethodService;
import org.javeriana.codequest.service.entity.LessonContentService;
import org.javeriana.codequest.service.entity.LessonService;
import org.javeriana.codequest.service.entity.MenuItemService;
import org.javeriana.codequest.service.entity.ModuleModelService;
import org.javeriana.codequest.service.entity.OptionFormService;
import org.javeriana.codequest.service.entity.PostService;
import org.javeriana.codequest.service.entity.PowerService;
import org.javeriana.codequest.service.entity.PremiumPlanService;
import org.javeriana.codequest.service.entity.ProductService;
import org.javeriana.codequest.service.entity.ProjectService;
import org.javeriana.codequest.service.entity.QuestionFormService;
import org.javeriana.codequest.service.entity.QuestionService;
import org.javeriana.codequest.service.entity.RequirementService;
import org.javeriana.codequest.service.entity.ResourceModelService;
import org.javeriana.codequest.service.entity.SkillService;
import org.javeriana.codequest.service.entity.TechnologyService;
import org.javeriana.codequest.service.entity.TestCaseService;
import org.javeriana.codequest.service.entity.TopicService;
import org.javeriana.codequest.service.entity.TrendService;
import org.javeriana.codequest.service.entity.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;

@Component
@Transactional
public class DatabaseInit {

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private CareerPathService careerPathService;

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private CodeExplanationService codeExplanationService;

    @Autowired
    private CommentModelService commentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ExamResultsService examResultsService;

    @Autowired
    private FeaturedUserService featuredUserService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private LearningMethodService learningMethodService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonContentService lessonContentService;

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private ModuleModelService moduleService;

    @Autowired
    private OptionFormService optionFormService;

    @Autowired
    private PostService postService;

    @Autowired
    private PowerService powerService;

    @Autowired
    private PremiumPlanService premiumPlanService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionFormService questionFormService;

    @Autowired
    private RequirementService requirementService;

    @Autowired
    private ResourceModelService resourceService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private TechnologyService technologyService;

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private TrendService trendService;

    @Autowired
    private UserProfileService userProfileService;

    @PostConstruct
    public void init() {
        initAchievements();
        initBadges();
        initCareerPaths();
        initChallenges();
        initChatMessages();
        initCodeExplanations();
        initInstructors();
        initCourses();
        initExamResults();
        initFeaturedUsers();
        initLearningMethods();
        initMenuItems();
        initPowers();
        initPremiumPlans();
        initProducts();
        initProjects();
        initQuestions();
        initQuestionForms();
        initRequirements();
        initResources();
        initSkills();
        initTechnologies();
        initTestCases();
        initTrends();
        initPosts();
        initProfileUsers();
    }

    private void initAchievements() {
        List<Achievement> achievements = Arrays.asList(
                // Logros iniciales existentes
                createAchievement("Primera Racha", "Mantén una racha de aprendizaje por 3 días consecutivos", "Progreso", Achievement.Rarity.COMÚN, 50, "🔥", false),
                createAchievement("Racha de Fuego", "Mantén una racha de aprendizaje por 15 días consecutivos", "Progreso", Achievement.Rarity.RARO, 200, "🔥", true),
                createAchievement("Maestro de la Racha", "Mantén una racha de aprendizaje por 30 días consecutivos", "Progreso", Achievement.Rarity.ÉPICO, 500, "🔥", false),
                createAchievement("Primer Curso", "Completa tu primer curso en CodeQuest", "Cursos", Achievement.Rarity.COMÚN, 100, "📚", false),
                createAchievement("Estudiante Dedicado", "Completa 5 cursos", "Cursos", Achievement.Rarity.RARO, 300, "📚", false),
                createAchievement("Primer Proyecto", "Completa tu primer proyecto", "Proyectos", Achievement.Rarity.COMÚN, 150, "🚀", false),
                createAchievement("Desafío Aceptado", "Completa tu primer desafío de código", "Desafíos", Achievement.Rarity.COMÚN, 75, "⚔️", false),
                createAchievement("Colaborador", "Ayuda a 10 compañeros en el foro", "Comunidad", Achievement.Rarity.ÉPICO, 600, "🤝", false),
                // --- Logros adicionales del frontend ---

                // 🏆 Progreso
                createAchievement("Primeros Pasos", "Completa tu primer curso en CodeQuest", "Progreso", Achievement.Rarity.COMÚN, 50, "🎯", true),
                createAchievement("Aprendiz Dedicado", "Completa 5 cursos diferentes", "Progreso", Achievement.Rarity.COMÚN, 150, "📚", true),
                createAchievement("Maestro del Conocimiento", "Completa 25 cursos en CodeQuest", "Progreso", Achievement.Rarity.RARO, 500, "🎓", false),
                createAchievement("Leyenda del Aprendizaje", "Completa 100 cursos en la plataforma", "Progreso", Achievement.Rarity.LEGENDARIO, 2500, "🏆", false),
                createAchievement("Racha de 7 Días", "Aprende durante 7 días consecutivos", "Progreso", Achievement.Rarity.COMÚN, 100, "🔥", true),
                createAchievement("Meses de Dedicación", "Aprende durante 3 meses consecutivos", "Progreso", Achievement.Rarity.RARO, 750, "🗓️", false),
                createAchievement("Año de Sabiduría", "Aprende durante 12 meses consecutivos", "Progreso", Achievement.Rarity.LEGENDARIO, 5000, "🌟", false),
                createAchievement("Velocidad del Rayo", "Completa un curso en menos de 24 horas", "Progreso", Achievement.Rarity.ÉPICO, 1000, "⚡", false),
                createAchievement("Perfeccionista", "Obtén 100% en todos los quizzes de un curso", "Progreso", Achievement.Rarity.RARO, 300, "💯", true),
                createAchievement("Coleccionista de Cursos", "Inscríbete en 50 cursos diferentes", "Progreso", Achievement.Rarity.ÉPICO, 1200, "📦", false),
                createAchievement("Explorador del Conocimiento", "Completa cursos en 5 categorías diferentes", "Progreso", Achievement.Rarity.RARO, 400, "🧭", false),
                createAchievement("Polímata Digital", "Domina 10 categorías diferentes", "Progreso", Achievement.Rarity.LEGENDARIO, 3000, "🎭", false),
                createAchievement("Sin Descanso", "Completa 10 horas de aprendizaje continuo", "Progreso", Achievement.Rarity.ÉPICO, 800, "⏳", false),
                createAchievement("Madrugador del Código", "Aprende antes de las 6 AM", "Progreso", Achievement.Rarity.RARO, 250, "🌅", false),
                createAchievement("Noctámbulo Digital", "Aprende después de la medianoche", "Progreso", Achievement.Rarity.RARO, 250, "🌙", true),
                // 💻 Tecnología
                createAchievement("Hola Mundo", "Completa tu primer programa en cualquier lenguaje", "Tecnología", Achievement.Rarity.COMÚN, 50, "👋", true),
                createAchievement("Maestro JavaScript", "Domina todos los conceptos avanzados de JavaScript", "Tecnología", Achievement.Rarity.ÉPICO, 1500, "⚡", false),
                createAchievement("Rey de React", "Crea 10 aplicaciones con React", "Tecnología", Achievement.Rarity.RARO, 600, "⚛️", false),
                createAchievement("Ninja de Python", "Resuelve 100 problemas con Python", "Tecnología", Achievement.Rarity.ÉPICO, 1200, "🐍", false),
                createAchievement("Full Stack Developer", "Domina tanto frontend como backend", "Tecnología", Achievement.Rarity.LEGENDARIO, 3000, "🚀", false),
                createAchievement("Mobile First", "Crea 5 aplicaciones móviles", "Tecnología", Achievement.Rarity.RARO, 750, "📱", false),
                createAchievement("Cloud Architect", "Despliega 10 proyectos en la nube", "Tecnología", Achievement.Rarity.ÉPICO, 1800, "☁️", false),
                createAchievement("Database Master", "Domina 3 sistemas de bases de datos diferentes", "Tecnología", Achievement.Rarity.RARO, 900, "🗄️", false),
                createAchievement("DevOps Engineer", "Automatiza el deployment de 5 proyectos", "Tecnología", Achievement.Rarity.ÉPICO, 1600, "🔧", false),
                createAchievement("AI Explorer", "Completa 3 proyectos de machine learning", "Tecnología", Achievement.Rarity.LEGENDARIO, 2500, "🤖", false),
                createAchievement("Blockchain Pioneer", "Crea tu primer smart contract", "Tecnología", Achievement.Rarity.ÉPICO, 1400, "⛓️", false),
                createAchievement("Game Developer", "Desarrolla 3 videojuegos funcionales", "Tecnología", Achievement.Rarity.RARO, 800, "🎮", false),
                createAchievement("Security Expert", "Identifica y soluciona 50 vulnerabilidades", "Tecnología", Achievement.Rarity.LEGENDARIO, 2800, "🛡️", false),
                createAchievement("IoT Creator", "Conecta 5 dispositivos IoT", "Tecnología", Achievement.Rarity.RARO, 700, "📶", false),
                createAchievement("Quantum Computing Initiate", "Completa el curso de computación cuántica", "Tecnología", Achievement.Rarity.MÍTICO, 5000, "⚛️", false)
        );

        achievements.forEach(achievementService::save);
    }

    private Achievement createAchievement(String name, String desc, String cat, Achievement.Rarity rarity, Integer pts, String img, Boolean unlocked) {
        Achievement a = new Achievement();
        a.setName(name);
        a.setDescription(desc);
        a.setCategory(cat);
        a.setRarity(rarity);
        a.setPoints(pts);
        a.setImage(img);
        a.setUnlocked(unlocked);
        a.setRequirements(desc);
        return a;
    }

    private void initBadges() {
        List<Badge> badges = Arrays.asList(
                createBadge("Python Master", "Completa todos los cursos de Python", "🐍", false, 500, "Python"),
                createBadge("JavaScript Ninja", "Domina JavaScript completando todos los cursos avanzados", "⚡", false, 500, "JavaScript"),
                createBadge("Java Expert", "Conviértete en experto en Java", "☕", false, 500, "Java"),
                createBadge("Web Developer", "Completa la ruta de desarrollo web", "🌐", false, 600, "Web"),
                createBadge("Mobile Developer", "Completa la ruta de desarrollo móvil", "📱", false, 600, "Mobile"),
                createBadge("Data Scientist", "Completa la ruta de ciencia de datos", "📊", false, 700, "Data"),
                createBadge("Cloud Expert", "Completa cursos de AWS, Azure y GCP", "☁️", false, 600, "Cloud"),
                createBadge("Algorithm Master", "Resuelve 100 problemas de algoritmos", "🧮", false, 750, "Algorithms")
        );
        badges.forEach(badgeService::save);
    }

    private Badge createBadge(String name, String desc, String icon, Boolean earned, Integer xp, String cat) {
        Badge b = new Badge();
        b.setName(name);
        b.setDescription(desc);
        b.setIcon(icon);
        b.setEarned(earned);
        b.setXp(xp);
        b.setCategory(cat);
        return b;
    }

    private void initCareerPaths() {
        List<CareerPath> paths = Arrays.asList(
                createCareerPath("Desarrollador Web Full Stack", "Domina frontend y backend",
                        "Aprende a crear aplicaciones web completas desde cero", "🌐", "Full Stack Developer",
                        "Junior", 15000, 5000, 10000, "$40,000 - $120,000",
                        Arrays.asList("Empresas tecnológicas", "Startups", "Freelance", "Agencias digitales"),
                        Arrays.asList("React", "Node.js", "MongoDB", "Express", "HTML/CSS")),
                createCareerPath("Desarrollador Móvil", "Crea apps nativas y multiplataforma",
                        "Domina el desarrollo de aplicaciones móviles para iOS y Android", "📱", "Mobile Developer",
                        "Junior", 13000, 3000, 10000, "$40,000 - $115,000",
                        Arrays.asList("Apps iOS", "Apps Android", "React Native", "Flutter"),
                        Arrays.asList("React Native", "Swift", "Kotlin", "Firebase", "Flutter")),
                createCareerPath("Científico de Datos", "Extrae insights de los datos",
                        "Aprende a analizar datos y crear modelos predictivos", "📊", "Data Scientist",
                        "Intermediate", 18000, 7000, 11000, "$60,000 - $150,000",
                        Arrays.asList("Machine Learning", "Análisis de datos", "Visualización", "Big Data"),
                        Arrays.asList("Python", "R", "Pandas", "Scikit-learn", "TensorFlow")),
                createCareerPath("Ingeniero DevOps", "Automatiza y optimiza infraestructura",
                        "Domina CI/CD, cloud y automatización", "🔧", "DevOps Engineer",
                        "Intermediate", 16000, 6500, 9500, "$55,000 - $140,000",
                        Arrays.asList("CI/CD", "Cloud Infrastructure", "Automatización", "Monitoreo"),
                        Arrays.asList("Docker", "Kubernetes", "Jenkins", "Terraform", "AWS")),
                createCareerPath("Especialista en Ciberseguridad", "Protege sistemas y datos",
                        "Conviértete en experto en seguridad informática", "🔒", "Security Specialist",
                        "Advanced", 17000, 7500, 9500, "$60,000 - $160,000",
                        Arrays.asList("Pentesting", "Security Audits", "Ethical Hacking", "Compliance"),
                        Arrays.asList("Kali Linux", "Metasploit", "Wireshark", "OWASP", "Python")),
                createCareerPath("Desarrollador Backend", "Arquitecto de sistemas del lado del servidor",
                        "Especialízate en APIs, bases de datos y lógica de negocio", "⚙️", "Backend Developer",
                        "Intermediate", 14000, 6000, 8000, "$45,000 - $130,000",
                        Arrays.asList("APIs RESTful", "Microservicios", "Bases de datos", "Cloud computing"),
                        Arrays.asList("Node.js", "Python", "PostgreSQL", "Docker", "AWS")),
                createCareerPath("Desarrollador Frontend", "Especialista en interfaces de usuario",
                        "Conviértete en experto en crear experiencias visuales increíbles", "🎨", "Frontend Developer",
                        "Junior", 12000, 4000, 8000, "$35,000 - $100,000",
                        Arrays.asList("Diseño web", "UI/UX", "Aplicaciones SPA", "E-commerce"),
                        Arrays.asList("React", "Vue.js", "TypeScript", "Tailwind CSS", "Webpack")),
                createCareerPath("Ingeniero de Machine Learning", "Construye sistemas inteligentes",
                        "Especialízate en IA y aprendizaje automático", "🤖", "ML Engineer",
                        "Advanced", 20000, 8000, 12000, "$70,000 - $180,000",
                        Arrays.asList("Deep Learning", "NLP", "Computer Vision", "AI Research"),
                        Arrays.asList("PyTorch", "TensorFlow", "Keras", "OpenCV", "Transformers"))
        );
        paths.forEach(careerPathService::save);
    }

    private CareerPath createCareerPath(String title, String subtitle, String desc, String icon,
            String role, String level, Integer totalXP, Integer currentXP,
            Integer requiredXP, String salary, List<String> opps, List<String> techs) {
        CareerPath cp = new CareerPath();
        cp.setTitle(title);
        cp.setSubtitle(subtitle);
        cp.setDescription(desc);
        cp.setIcon(icon);
        cp.setRole(role);
        cp.setLevel(level);
        cp.setTotalXP(totalXP);
        cp.setCurrentXP(currentXP);
        cp.setRequiredXP(requiredXP);
        cp.setSalaryRange(salary);
        cp.setSelected(false);
        cp.setOpportunities(opps);
        cp.setTechnologies(techs);
        return cp;
    }

    private void initChallenges() {
        List<Challenge> challenges = Arrays.asList(
                createChallenge("FizzBuzz", "Implementa el clásico problema FizzBuzz", "🔢", 50, "Algoritmo", false),
                createChallenge("Palíndromo", "Verifica si una cadena es un palíndromo", "📝", 50, "String", false),
                createChallenge("Fibonacci", "Genera la secuencia de Fibonacci", "🌀", 75, "Recursión", false),
                createChallenge("Búsqueda Binaria", "Implementa búsqueda binaria en un array ordenado", "🔍", 100, "Búsqueda", false),
                createChallenge("Árbol Binario", "Implementa un árbol binario de búsqueda", "🌳", 150, "Estructuras de Datos", false),
                createChallenge("API REST", "Crea una API REST completa con CRUD", "🌐", 150, "Backend", false),
                createChallenge("Sistema de Caché", "Implementa un sistema de caché LRU", "💾", 150, "Optimización", false),
                createChallenge("Machine Learning", "Entrena un modelo de clasificación", "🤖", 250, "AI/ML", false)
        );
        challenges.forEach(challengeService::save);
    }

    private Challenge createChallenge(String title, String desc, String icon, Integer xp, String type, Boolean completed) {
        Challenge c = new Challenge();
        c.setTitle(title);
        c.setDescription(desc);
        c.setIcon(icon);
        c.setXp(xp);
        c.setType(type);
        c.setCompleted(completed);
        return c;
    }

    private void initChatMessages() {
        List<ChatMessage> messages = Arrays.asList(
                createChatMessage("¿Podrías explicarme qué es una función en Python?", true, LocalDateTime.now().minusMinutes(10), null),
                createChatMessage("Una función es un bloque de código reutilizable que realiza una tarea específica. Se define con 'def' seguido del nombre.", false, LocalDateTime.now().minusMinutes(9), ChatMessage.MessageType.EVALUACION),
                createChatMessage("Mi código tiene un error en el bucle for", true, LocalDateTime.now().minusMinutes(8), null),
                createChatMessage("Revisa la indentación del código dentro del bucle. En Python, la indentación es crucial.", false, LocalDateTime.now().minusMinutes(7), ChatMessage.MessageType.PISTA),
                createChatMessage("¿Cómo puedo mejorar el rendimiento de mi consulta SQL?", true, LocalDateTime.now().minusMinutes(6), null),
                createChatMessage("Considera agregar índices a las columnas que usas en WHERE y JOIN. También evita SELECT *.", false, LocalDateTime.now().minusMinutes(5), ChatMessage.MessageType.SUGERENCIA),
                createChatMessage("No entiendo la diferencia entre var, let y const", true, LocalDateTime.now().minusMinutes(4), null),
                createChatMessage("'var' tiene scope de función, 'let' de bloque y 'const' también de bloque pero inmutable.", false, LocalDateTime.now().minusMinutes(3), ChatMessage.MessageType.EVALUACION)
        );
        messages.forEach(chatMessageService::save);
    }

    private ChatMessage createChatMessage(String text, Boolean isUser, LocalDateTime timestamp, ChatMessage.MessageType type) {
        ChatMessage cm = new ChatMessage();
        cm.setText(text);
        cm.setIsUser(isUser);
        cm.setTimestamp(timestamp);
        cm.setType(type);
        return cm;
    }

    private void initCodeExplanations() {
        List<CodeExplanation> explanations = Arrays.asList(
                createCodeExplanation(1, "def fibonacci(n):", "Define una función llamada fibonacci que recibe un parámetro n"),
                createCodeExplanation(2, "    if n <= 1:", "Verifica si n es 0 o 1, caso base de la recursión"),
                createCodeExplanation(3, "        return n", "Retorna n directamente para los casos base"),
                createCodeExplanation(4, "    return fibonacci(n-1) + fibonacci(n-2)", "Llamada recursiva que suma los dos números anteriores"),
                createCodeExplanation(5, "const fetchData = async () => {", "Declara una función asíncrona usando arrow function"),
                createCodeExplanation(6, "    const response = await fetch(url);", "Espera la respuesta de la petición HTTP"),
                createCodeExplanation(7, "    const data = await response.json();", "Convierte la respuesta a formato JSON"),
                createCodeExplanation(8, "    return data;", "Retorna los datos procesados")
        );
        explanations.forEach(codeExplanationService::save);
    }

    private CodeExplanation createCodeExplanation(Integer line, String code, String explanation) {
        CodeExplanation ce = new CodeExplanation();
        ce.setLine(line);
        ce.setCode(code);
        ce.setExplanation(explanation);
        return ce;
    }

    private void initInstructors() {
        List<Instructor> instructors = Arrays.asList(
                createInstructor("Dr. Ana García", "👩‍🏫"),
                createInstructor("Carlos Mendoza", "👨‍💻"),
                createInstructor("María López", "👩‍💼"),
                createInstructor("Juan Pérez", "👨‍🔬"),
                createInstructor("Laura Martínez", "👩‍🎓"),
                createInstructor("Diego Rodríguez", "👨‍🏫"),
                createInstructor("Sofia Chen", "👩‍💻"),
                createInstructor("Roberto Silva", "👨‍💼"),
                createInstructor("Santiago Castro Garzón", "👨‍🏫") // Nuevo instructor para C++
        );
        instructors.forEach(instructorService::save);
    }

    private Instructor createInstructor(String name, String avatar) {
        Instructor i = new Instructor();
        i.setName(name);
        i.setAvatar(avatar);
        return i;
    }

    private void initCourses() {
        // Obtener instructores recién guardados (attached)
        List<Instructor> instructors = instructorService.findAll();

        List<Course> courses = Arrays.asList(
                createCourse(
                        "JavaScript Moderno: De Cero a Experto",
                        "Domina JavaScript ES6+ con proyectos reales. Aprende desde fundamentos hasta conceptos avanzados como async/await, closures y programación funcional.",
                        "Frontend", "Principiante", 4.8, "60 horas", 21500, 120, 0,
                        "Variables y Tipos de Datos",
                        "https://images.unsplash.com/photo-1627398242454-45a1465c2479?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1627398242454-45a1465c2479?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$49.99", "$89.99", 850, true, true,
                        Arrays.asList("ES6+ Features", "Async/Await", "Closures", "DOM Manipulation", "Event Loop"),
                        Arrays.asList("Conocimientos básicos de programación", "HTML y CSS básico"),
                        Arrays.asList("JavaScript", "Frontend", "ES6"),
                        instructors.get(0) // Dr. Ana García
                ),
                createCourse(
                        "Python para Análisis de Datos y Machine Learning",
                        "Conviértete en Data Scientist con Python. Domina Pandas, NumPy, Scikit-learn y construye modelos predictivos.",
                        "Data Science", "Intermedio", 4.9, "75 horas", 18700, 180, 45,
                        "Introducción a Pandas",
                        "https://images.unsplash.com/photo-1526379879527-8559ecfcaec0?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1526379879527-8559ecfcaec0?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$79.99", "$129.99", 1200, true, true,
                        Arrays.asList("Pandas avanzado", "NumPy", "Scikit-learn", "Visualización", "Modelado predictivo"),
                        Arrays.asList("Python básico", "Matemáticas básicas", "Estadística fundamental"),
                        Arrays.asList("Python", "MachineLearning", "DataScience"),
                        instructors.get(1) // Carlos Mendoza
                ),
                createCourse(
                        "React + Next.js: Desarrollo Web Profesional",
                        "Crea aplicaciones web modernas con React 18 y Next.js 14. Incluye SSR, SSG y optimización de performance.",
                        "Frontend", "Intermedio", 4.9, "55 horas", 23400, 145, 30,
                        "Fundamentos de React",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$69.99", "$119.99", 950, true, true,
                        Arrays.asList("React Hooks", "Next.js App Router", "Server Components", "Optimización", "Deployment"),
                        Arrays.asList("JavaScript avanzado", "HTML/CSS", "Conceptos de React básico"),
                        Arrays.asList("React", "NextJS", "Frontend"),
                        instructors.get(2) // María López
                ),
                createCourse(
                        "Node.js y Express: Backend con TypeScript",
                        "Desarrolla APIs REST escalables con Node.js, Express y TypeScript. Incluye autenticación, bases de datos y testing.",
                        "Backend", "Intermedio", 4.7, "50 horas", 15600, 110, 0,
                        "Configuración de TypeScript",
                        "https://images.unsplash.com/photo-1563089145-599997674d42?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1563089145-599997674d42?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$59.99", "$99.99", 800, false, true,
                        Arrays.asList("TypeScript", "Express.js", "APIs REST", "Autenticación JWT", "Testing"),
                        Arrays.asList("JavaScript avanzado", "Conceptos de backend", "Conocimientos de HTTP"),
                        Arrays.asList("NodeJS", "TypeScript", "Backend"),
                        instructors.get(3) // Juan Pérez
                ),
                createCourse(
                        "Flutter & Dart: Apps Móviles Multiplataforma",
                        "Desarrolla aplicaciones móviles nativas para iOS y Android con un solo código base usando Flutter.",
                        "Mobile", "Principiante", 4.8, "65 horas", 18900, 135, 0,
                        "Introducción a Dart",
                        "https://es.fiverr.com/maisam_abbas_/develop-professional-a-mobile-app-using-flutter",
                        "https://es.fiverr.com/maisam_abbas_/develop-professional-a-mobile-app-using-flutter",
                        "$64.99", "$109.99", 900, true, false,
                        Arrays.asList("Dart avanzado", "Widgets personalizados", "State Management", "Animaciones", "Firebase"),
                        Arrays.asList("Programación básica", "Conceptos OOP"),
                        Arrays.asList("Flutter", "Dart", "Mobile"),
                        instructors.get(4) // Laura Martínez
                ),
                createCourse(
                        "AWS Cloud Practitioner: Fundamentos de la Nube",
                        "Prepárate para la certificación AWS Cloud Practitioner. Domina los servicios fundamentales de AWS.",
                        "Cloud", "Principiante", 4.6, "40 horas", 12300, 85, 25,
                        "Introducción a AWS",
                        "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$89.99", "$149.99", 700, false, true,
                        Arrays.asList("EC2 y S3", "IAM y Security", "VPC", "RDS", "Cost Optimization"),
                        Arrays.asList("Conocimientos básicos de TI", "Conceptos de redes"),
                        Arrays.asList("AWS", "Cloud", "DevOps"),
                        instructors.get(5) // Diego Rodríguez
                ),
                createCourse(
                        "Docker & Kubernetes: Contenedores y Orquestación",
                        "Master en contenedores Docker y orquestación con Kubernetes. Despliega aplicaciones escalables.",
                        "DevOps", "Intermedio", 4.9, "45 horas", 14200, 95, 0,
                        "Fundamentos de Docker",
                        "https://images.unsplash.com/photo-1626721105368-a69248e93b32?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1626721105368-a69248e93b32?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$74.99", "$124.99", 850, true, true,
                        Arrays.asList("Docker avanzado", "Kubernetes clusters", "Helm charts", "CI/CD", "Monitoring"),
                        Arrays.asList("Linux básico", "Conceptos de redes", "Experiencia en línea de comandos"),
                        Arrays.asList("Docker", "Kubernetes", "DevOps"),
                        instructors.get(6) // Sofia Chen
                ),
                createCourse(
                        "Ciberseguridad Ofensiva: Hacking Ético",
                        "Aprende técnicas de pentesting y seguridad ofensiva. Domina herramientas como Metasploit y Burp Suite.",
                        "Security", "Avanzado", 4.8, "80 horas", 8900, 200, 0,
                        "Reconocimiento y Footprinting",
                        "https://images.unsplash.com/photo-1550751827-4bd374c3f58b?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1550751827-4bd374c3f58b?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$99.99", "$169.99", 1500, false, false,
                        Arrays.asList("Pentesting Web", "Explotación", "Post-explotación", "OWASP Top 10", "Forensics"),
                        Arrays.asList("Redes avanzadas", "Linux", "Programación básica", "Conceptos de seguridad"),
                        Arrays.asList("Security", "Hacking", "Pentesting"),
                        instructors.get(7) // Roberto Silva
                ),
                createCourse(
                        "Vue.js 3: Desarrollo Frontend con Composition API",
                        "Domina Vue.js 3 con Composition API. Crea aplicaciones reactivas y de alto rendimiento.",
                        "Frontend", "Intermedio", 4.7, "48 horas", 16700, 125, 60,
                        "Vue.js Fundamentals",
                        "https://images.unsplash.com/photo-1633356122102-3fe601e05bd2?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1633356122102-3fe601e05bd2?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$54.99", "$94.99", 750, true, false,
                        Arrays.asList("Composition API", "Vue Router", "Pinia State Management", "Testing", "Performance"),
                        Arrays.asList("JavaScript avanzado", "HTML/CSS", "Conceptos de Vue.js básico"),
                        Arrays.asList("VueJS", "Frontend", "JavaScript"),
                        instructors.get(0) // Dr. Ana García
                ),
                createCourse(
                        "SQL Avanzado y Optimización de Bases de Datos",
                        "Domina SQL avanzado, optimización de queries y diseño de bases de datos escalables.",
                        "Backend", "Intermedio", 4.8, "35 horas", 13400, 70, 70,
                        "Fundamentos de SQL",
                        "https://images.unsplash.com/photo-1544383835-bda2bc66a55d?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1544383835-bda2bc66a55d?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "Gratis", null, 600, false, false,
                        Arrays.asList("Query Optimization", "Indexing", "Transactions", "Stored Procedures", "Normalization"),
                        Arrays.asList("SQL básico", "Conceptos de bases de datos"),
                        Arrays.asList("SQL", "Database", "PostgreSQL"),
                        instructors.get(1) // Carlos Mendoza
                ),
                createCourse(
                        "Go Programming: Sistemas Concurrentes y Escalables",
                        "Aprende Go para desarrollar sistemas backend de alta concurrencia y alto rendimiento.",
                        "Backend", "Intermedio", 4.7, "42 horas", 9800, 100, 0,
                        "Sintaxis de Go",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$59.99", "$99.99", 800, false, true,
                        Arrays.asList("Concurrencia", "Goroutines", "Channels", "Testing", "APIs REST"),
                        Arrays.asList("Programación básica", "Conceptos de concurrencia"),
                        Arrays.asList("Go", "Backend", "Concurrency"),
                        instructors.get(2) // María López
                ),
                createCourse(
                        "TensorFlow y Deep Learning: Redes Neuronales",
                        "Domina el deep learning con TensorFlow. Crea redes neuronales para visión computacional y NLP.",
                        "AI/ML", "Avanzado", 4.9, "70 horas", 11200, 165, 0,
                        "Introducción a TensorFlow",
                        "https://images.unsplash.com/photo-1555949963-aa79dcee981c?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1555949963-aa79dcee981c?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$89.99", "$159.99", 1400, true, true,
                        Arrays.asList("Redes Neuronales", "Computer Vision", "NLP", "Transfer Learning", "Model Deployment"),
                        Arrays.asList("Python avanzado", "Matemáticas", "Machine Learning básico"),
                        Arrays.asList("TensorFlow", "DeepLearning", "AI"),
                        instructors.get(3) // Juan Pérez
                ),
                createCourse(
                        "Angular 16: Desarrollo Enterprise con TypeScript",
                        "Crea aplicaciones empresariales escalables con Angular 16, RxJS y mejores prácticas.",
                        "Frontend", "Intermedio", 4.6, "58 horas", 14500, 140, 0,
                        "TypeScript para Angular",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$69.99", "$119.99", 900, false, false,
                        Arrays.asList("Components", "Services", "RxJS", "Routing", "Testing"),
                        Arrays.asList("TypeScript", "JavaScript avanzado", "HTML/CSS"),
                        Arrays.asList("Angular", "TypeScript", "Frontend"),
                        instructors.get(4) // Laura Martínez
                ),
                createCourse(
                        "Blockchain y Smart Contracts con Solidity",
                        "Aprende desarrollo blockchain y crea smart contracts con Solidity para Ethereum.",
                        "Blockchain", "Intermedio", 4.7, "52 horas", 7600, 120, 0,
                        "Fundamentos de Blockchain",
                        "https://images.unsplash.com/photo-1639762681485-074b7f938ba0?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1639762681485-074b7f938ba0?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$79.99", "$139.99", 1100, true, false,
                        Arrays.asList("Solidity", "Smart Contracts", "DeFi", "NFTs", "Web3.js"),
                        Arrays.asList("JavaScript", "Programación básica", "Conceptos de criptografía"),
                        Arrays.asList("Blockchain", "Solidity", "Web3"),
                        instructors.get(5) // Diego Rodríguez
                ),
                createCourse(
                        "Git Avanzado: Workflows y Colaboración Profesional",
                        "Domina Git para trabajo en equipo. Aprende workflows profesionales y resolución de conflictos.",
                        "Tools", "Principiante", 4.9, "25 horas", 19800, 50, 50,
                        "Comandos Básicos de Git",
                        "https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png",
                        "https://miro.medium.com/v2/resize:fit:1400/1*_6M2zk7d9wXp2T_7bVgn8w.png",
                        "Gratis", null, 400, false, false,
                        Arrays.asList("Branching Strategies", "Git Flow", "Conflict Resolution", "Hooks", "CI/CD Integration"),
                        Arrays.asList("Conocimientos básicos de Git"),
                        Arrays.asList("Git", "DevOps", "Collaboration"),
                        instructors.get(6) // Sofia Chen
                ),
                createCourse(
                        "Spring Boot: Desarrollo Java Empresarial",
                        "Crea aplicaciones empresariales con Spring Boot, Spring Security y microservicios.",
                        "Backend", "Intermedio", 4.7, "65 horas", 12300, 150, 0,
                        "Introducción a Spring Boot",
                        "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$74.99", "$129.99", 1000, false, true,
                        Arrays.asList("Spring MVC", "Spring Security", "JPA/Hibernate", "Testing", "Microservices"),
                        Arrays.asList("Java avanzado", "Conceptos OOP", "Bases de datos"),
                        Arrays.asList("Spring", "Java", "Backend"),
                        instructors.get(7) // Roberto Silva
                ),
                createCourse(
                        "UI/UX Design para Desarrolladores",
                        "Aprende principios de diseño UI/UX para crear interfaces atractivas y usables.",
                        "Design", "Principiante", 4.8, "30 horas", 16700, 75, 25,
                        "Principios de Diseño",
                        "https://images.unsplash.com/photo-1561070791-2526d30994b5?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1561070791-2526d30994b5?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$49.99", "$89.99", 550, true, false,
                        Arrays.asList("Design Thinking", "Figma", "Prototyping", "User Research", "Accessibility"),
                        Arrays.asList("Conocimientos básicos de diseño", "Interés en experiencia de usuario"),
                        Arrays.asList("UI/UX", "Design", "Figma"),
                        instructors.get(0) // Dr. Ana García
                ),
                createCourse(
                        "Rust: Sistemas de Alto Rendimiento y Seguros",
                        "Domina Rust para desarrollar sistemas de alto rendimiento con seguridad de memoria.",
                        "Systems", "Avanzado", 4.8, "55 horas", 6800, 130, 0,
                        "Sintaxis de Rust",
                        "https://images.unsplash.com/photo-1589652717521-10c0d092dea9?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1589652717521-10c0d092dea9?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$69.99", "$119.99", 950, false, true,
                        Arrays.asList("Ownership", "Concurrency", "Memory Safety", "WebAssembly", "Systems Programming"),
                        Arrays.asList("Programación avanzada", "Conceptos de sistemas", "C/C++ experiencia útil"),
                        Arrays.asList("Rust", "Systems", "Performance"),
                        instructors.get(1) // Carlos Mendoza
                ),
                createCourse(
                        "GraphQL: APIs Modernas con Apollo y React",
                        "Crea APIs modernas con GraphQL. Integra con React usando Apollo Client.",
                        "Backend", "Intermedio", 4.7, "38 horas", 11200, 90, 0,
                        "Fundamentos de GraphQL",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$54.99", "$94.99", 700, true, false,
                        Arrays.asList("GraphQL Schema", "Resolvers", "Apollo Server", "Apollo Client", "Caching"),
                        Arrays.asList("JavaScript", "Node.js básico", "Conceptos de APIs"),
                        Arrays.asList("GraphQL", "API", "Backend"),
                        instructors.get(2) // María López
                ),
                createCourse(
                        "DevOps con Azure: CI/CD y Infraestructura como Código",
                        "Implementa pipelines CI/CD y gestiona infraestructura en Azure con Terraform.",
                        "DevOps", "Intermedio", 4.6, "47 horas", 8900, 110, 0,
                        "Introducción a Azure",
                        "https://images.unsplash.com/photo-1551288049-bebda4e38f71?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "https://images.unsplash.com/photo-1551288049-bebda4e38f71?ixlib=rb-4.0.3&w=400&h=250&fit=crop&crop=center",
                        "$79.99", "$139.99", 850, false, true,
                        Arrays.asList("Azure Pipelines", "Terraform", "Kubernetes en Azure", "Monitoring", "Security"),
                        Arrays.asList("Conceptos de cloud", "Linux", "Scripting básico"),
                        Arrays.asList("Azure", "DevOps", "Cloud"),
                        instructors.get(3) // Juan Pérez
                ),
                createCourse(
                        "Introducción a la Programación con C++",
                        "Aprende programación desde cero con C++. Curso completo con metodologías de aprendizaje visual, auditiva, kinestésica y mixta. Ideal para principiantes que quieren dominar los fundamentos de la programación.",
                        "Programming", "Principiante", 4.9, "80 horas", 0, 200, 0,
                        "¿Qué es la programación?",
                        "https://i.imgur.com/XSgpcs0.gif",
                        "https://www.profesionalreview.com/wp-content/uploads/2024/07/Lenguaje-C.jpg",
                        "Gratis", null, 2000, true, true,
                        Arrays.asList(
                                "Fundamentos de programación y pensamiento algorítmico",
                                "Sintaxis completa de C++ desde variables hasta punteros",
                                "Estructuras de control: condicionales y ciclos",
                                "Funciones, modularización y recursividad",
                                "Manejo de arreglos, vectores y matrices",
                                "Programación orientada a objetos básica",
                                "Gestión de archivos y persistencia de datos",
                                "Proyecto final integrador aplicando todos los conceptos"
                        ),
                        Arrays.asList(
                                "Ningún conocimiento previo de programación necesario",
                                "Computadora con Windows, Linux o MacOS",
                                "Disposición para practicar y resolver ejercicios",
                                "Conexión a internet para acceder a materiales"
                        ),
                        Arrays.asList("C++", "Programming", "Beginner", "Algorithms", "DataStructures"),
                        instructors.get(8) // Prof. Miguel Ángel Torres
                )
        );

        // Guardar cursos primero
        courses.forEach(courseService::save);

        // Ahora crear módulos completos para el curso de Git Avanzado
        Course gitCourse = courses.stream()
                .filter(c -> c.getTitle().equals("Git Avanzado: Workflows y Colaboración Profesional"))
                .findFirst()
                .orElse(null);

        if (gitCourse != null) {
            initGitAdvancedModules(gitCourse);
        }

        Course cppCourse = courses.stream()
                .filter(c -> c.getTitle().equals("Introducción a la Programación con C++"))
                .findFirst()
                .orElse(null);

        if (cppCourse != null) {
            initCppIntroductionModules(cppCourse);
        }
    }

    private void initGitAdvancedModules(Course gitCourse) {
        // Módulo 1: Fundamentos de Git Revisitados
        ModuleModel module1 = createModule("Fundamentos de Git Revisitados",
                "Repaso de conceptos fundamentales de Git con enfoque en buenas prácticas",
                "4 horas", 80, 100, true);
        module1.setCourse(gitCourse);
        moduleService.save(module1);

        // Tema 1.1: Comandos Esenciales
        Topic topic1_1 = createTopic("Comandos Esenciales para el Trabajo Diario", true);
        topic1_1.setModule(module1);
        topicService.save(topic1_1);

        // Lecciones del Tema 1.1
        Lesson lesson1_1_1 = createLesson("Git Status y Log Avanzados", "15 min", true, false);
        lesson1_1_1.setTopic(topic1_1);

        LessonContent content1_1_1 = createLessonContent(
                "https://example.com/videos/git-status-advanced",
                "https://example.com/audio/git-status-advanced",
                "Git_Status_Avanzado.pdf",
                "git status --short\ngit log --oneline --graph --all\ngit log --since='2024-01-01'",
                "mindmap-git-status.png",
                "interactive-git-log",
                Arrays.asList(
                        new CodeExplanation(1, "git status --short", "Muestra el estado en formato compacto"),
                        new CodeExplanation(2, "git log --oneline --graph --all", "Muestra historial gráfico compacto de todas las ramas"),
                        new CodeExplanation(3, "git log --since='2024-01-01'", "Filtra commits desde fecha específica")
                )
        );

        lesson1_1_1.setContent(content1_1_1);
        lessonService.save(lesson1_1_1);

        Lesson lesson1_1_2 = createLesson("Staging y Commits Efectivos", "20 min", true, false);
        lesson1_1_2.setTopic(topic1_1);

        LessonContent content1_1_2 = createLessonContent(
                "https://example.com/videos/git-commit-effective",
                "https://example.com/audio/git-commit-effective",
                "Commits_Efectivos.pdf",
                "git add -p\ngit commit -m \"feat: add user authentication\\n\\n- Implement JWT token generation\\n- Add login endpoint\\n- Update user model\"",
                "mindmap-git-commit.png",
                "interactive-git-add",
                Arrays.asList(
                        new CodeExplanation(1, "git add -p", "Agrega cambios interactivamente, permitiendo revisar cada modificación"),
                        new CodeExplanation(2, "git commit -m \"feat: add user authentication\"", "Commit con mensaje siguiendo convencional commits")
                )
        );
        lesson1_1_2.setContent(content1_1_2);
        lessonService.save(lesson1_1_2);

        // Tema 1.2: Ramas y Merging
        Topic topic1_2 = createTopic("Manejo Avanzado de Ramas", true);
        topic1_2.setModule(module1);
        topicService.save(topic1_2);

        Lesson lesson1_2_1 = createLesson("Creación y Navegación de Ramas", "18 min", true, false);
        lesson1_2_1.setTopic(topic1_2);

        LessonContent content1_2_1 = createLessonContent(
                "https://example.com/videos/git-branching",
                "https://example.com/audio/git-branching",
                "Ramas_Avanzadas.pdf",
                "git branch feature/user-auth\ngit checkout feature/user-auth\ngit switch -c hotfix/critical-bug",
                "mindmap-git-branches.png",
                "interactive-git-branch",
                Arrays.asList(
                        new CodeExplanation(1, "git branch feature/user-auth", "Crea nueva rama para feature de autenticación"),
                        new CodeExplanation(2, "git checkout feature/user-auth", "Cambia a la rama recién creada"),
                        new CodeExplanation(3, "git switch -c hotfix/critical-bug", "Crea y cambia a rama de hotfix en un solo comando")
                )
        );
        lesson1_2_1.setContent(content1_2_1);
        lessonService.save(lesson1_2_1);

        // Módulo 2: Workflows de Colaboración
        ModuleModel module2 = createModule("Workflows de Colaboración",
                "Estrategias profesionales para trabajo en equipo con Git",
                "6 horas", 120, 75, false);
        module2.setCourse(gitCourse);
        moduleService.save(module2);

        // Tema 2.1: Git Flow
        Topic topic2_1 = createTopic("Git Flow: Workflow Estándar", false);
        topic2_1.setModule(module2);
        topicService.save(topic2_1);

        Lesson lesson2_1_1 = createLesson("Introducción a Git Flow", "25 min", false, true);
        lesson2_1_1.setTopic(topic2_1);

        LessonContent content2_1_1 = createLessonContent(
                "https://example.com/videos/git-flow-intro",
                "https://example.com/audio/git-flow-intro",
                "Git_Flow_Introduction.pdf",
                "git flow init\ngit flow feature start authentication\ngit flow feature finish authentication",
                "mindmap-git-flow.png",
                "interactive-git-flow",
                Arrays.asList(
                        new CodeExplanation(1, "git flow init", "Inicializa Git Flow en el repositorio"),
                        new CodeExplanation(2, "git flow feature start authentication", "Inicia nueva feature branch"),
                        new CodeExplanation(3, "git flow feature finish authentication", "Finaliza feature y mergea a develop")
                )
        );
        lesson2_1_1.setContent(content2_1_1);
        lessonService.save(lesson2_1_1);

        Lesson lesson2_1_2 = createLesson("Ramas Principales: main, develop, features", "30 min", false, false);
        lesson2_1_2.setTopic(topic2_1);

        LessonContent content2_1_2 = createLessonContent(
                "https://example.com/videos/git-flow-branches",
                "https://example.com/audio/git-flow-branches",
                "Git_Flow_Branches.pdf",
                "# main - producción\n# develop - desarrollo\n# feature/* - nuevas funcionalidades\n# release/* - preparación releases\n# hotfix/* - correcciones urgentes",
                "mindmap-git-flow-branches.png",
                "interactive-git-branches",
                Arrays.asList(
                        new CodeExplanation(1, "main", "Rama principal con código de producción"),
                        new CodeExplanation(2, "develop", "Rama de integración para desarrollo"),
                        new CodeExplanation(3, "feature/*", "Ramas temporales para nuevas funcionalidades")
                )
        );

        lesson2_1_2.setContent(content2_1_2);
        lessonService.save(lesson2_1_2);

        // Tema 2.2: GitHub Flow
        Topic topic2_2 = createTopic("GitHub Flow: Workflow Simplificado", false);
        topic2_2.setModule(module2);
        topicService.save(topic2_2);

        Lesson lesson2_2_1 = createLesson("Pull Requests y Code Review", "35 min", false, false);
        lesson2_2_1.setTopic(topic2_2);

        LessonContent content2_2_1 = createLessonContent(
                "https://example.com/videos/github-flow-pr",
                "https://example.com/audio/github-flow-pr",
                "Pull_Requests.pdf",
                "# Crear PR desde GitHub UI\n# Agregar revisores\n# Resolver comentarios\ngit push origin feature/auth",
                "mindmap-pull-requests.png",
                "interactive-pr-workflow",
                Arrays.asList(
                        new CodeExplanation(1, "Crear PR desde GitHub UI", "Interfaz web para crear Pull Requests"),
                        new CodeExplanation(2, "Agregar revisores", "Asignar colegas para revisión de código"),
                        new CodeExplanation(3, "git push origin feature/auth", "Subir cambios para crear PR")
                )
        );

        lesson2_2_1.setContent(content2_2_1);
        lessonService.save(lesson2_2_1);

        // Módulo 3: Resolución de Conflictos
        ModuleModel module3 = createModule("Resolución Avanzada de Conflictos",
                "Técnicas profesionales para manejar y resolver conflictos de merge",
                "5 horas", 100, 50, false);
        module3.setCourse(gitCourse);
        moduleService.save(module3);

        // Tema 3.1: Tipos de Conflictos
        Topic topic3_1 = createTopic("Identificación y Prevención", false);
        topic3_1.setModule(module3);
        topicService.save(topic3_1);

        Lesson lesson3_1_1 = createLesson("Conflictos Comunes y Su Origen", "22 min", false, false);
        lesson3_1_1.setTopic(topic3_1);

        LessonContent content3_1_1 = createLessonContent(
                "https://example.com/videos/git-conflicts",
                "https://example.com/audio/git-conflicts",
                "Tipos_Conflictos.pdf",
                "<<<<<<< HEAD\nconsole.log('Hello World');\n=======\nconsole.log('Hola Mundo');\n>>>>>>> feature/spanish",
                "mindmap-conflict-types.png",
                "interactive-conflict-simulation",
                Arrays.asList(
                        new CodeExplanation(1, "<<<<<<< HEAD", "Inicio del conflicto - versión actual"),
                        new CodeExplanation(2, "=======", "Separador entre las dos versiones"),
                        new CodeExplanation(3, ">>>>>>> feature/spanish", "Fin del conflicto - versión entrante")
                )
        );
        lesson3_1_1.setContent(content3_1_1);
        lessonService.save(lesson3_1_1);

        Lesson lesson3_1_2 = createLesson("Herramientas de Resolución", "28 min", false, false);
        lesson3_1_2.setTopic(topic3_1);

        LessonContent content3_1_2 = createLessonContent(
                "https://example.com/videos/git-tools",
                "https://example.com/audio/git-tools",
                "Herramientas_Resolucion.pdf",
                "git mergetool\ngit config --global merge.tool vscode\ngit add .\ngit commit -m \"Resolve merge conflicts\"",
                "mindmap-merge-tools.png",
                "interactive-merge-tool",
                Arrays.asList(
                        new CodeExplanation(1, "git mergetool", "Abre herramienta visual para resolver conflictos"),
                        new CodeExplanation(2, "git config --global merge.tool vscode", "Configura VS Code como herramienta de merge"),
                        new CodeExplanation(3, "git add .", "Marca conflictos resueltos como listos para commit")
                )
        );
        lesson3_1_2.setContent(content3_1_2);
        lessonService.save(lesson3_1_2);
        // Módulo 4: Hooks y Automatización
        ModuleModel module4 = createModule("Hooks y Automatización",
                "Automatiza tareas con Git Hooks y integración con CI/CD",
                "4 horas", 80, 25, false);
        module4.setCourse(gitCourse);
        moduleService.save(module4);

        // Tema 4.1: Git Hooks
        Topic topic4_1 = createTopic("Hooks Personalizados", false);
        topic4_1.setModule(module4);
        topicService.save(topic4_1);

        Lesson lesson4_1_1 = createLesson("Hooks de Cliente: pre-commit y pre-push", "32 min", false, false);
        lesson4_1_1.setTopic(topic4_1);

        LessonContent content4_1_1 = createLessonContent(
                "https://example.com/videos/git-hooks",
                "https://example.com/audio/git-hooks",
                "Git_Hooks.pdf",
                "#!/bin/bash\n# .git/hooks/pre-commit\necho \"Running tests...\"\nnpm test\nif [ $? -ne 0 ]; then\n    echo \"Tests failed!\"\n    exit 1\nfi",
                "mindmap-git-hooks.png",
                "interactive-hook-builder",
                Arrays.asList(
                        new CodeExplanation(1, "#!/bin/bash", "Shebang para script bash"),
                        new CodeExplanation(2, "npm test", "Ejecuta suite de pruebas"),
                        new CodeExplanation(3, "exit 1", "Sale con error si las pruebas fallan")
                )
        );
        lesson4_1_1.setContent(content4_1_1);
        lessonService.save(lesson4_1_1);

        // Tema 4.2: Integración CI/CD
        Topic topic4_2 = createTopic("Git en Pipelines de CI/CD", false);
        topic4_2.setModule(module4);
        topicService.save(topic4_2);

        Lesson lesson4_2_1 = createLesson("GitHub Actions para Automatización", "40 min", false, false);
        lesson4_2_1.setTopic(topic4_2);

        LessonContent content4_2_1 = createLessonContent(
                "https://example.com/videos/github-actions",
                "https://example.com/audio/github-actions",
                "GitHub_Actions.pdf",
                "name: CI Pipeline\non: [push, pull_request]\njobs:\n  test:\n    runs-on: ubuntu-latest\n    steps:\n      - uses: actions/checkout@v3\n      - run: npm install\n      - run: npm test",
                "mindmap-ci-cd.png",
                "interactive-ci-pipeline",
                Arrays.asList(
                        new CodeExplanation(1, "on: [push, pull_request]", "Dispara pipeline en push y PR"),
                        new CodeExplanation(2, "actions/checkout@v3", "Acción para checkout del código"),
                        new CodeExplanation(3, "npm test", "Ejecuta pruebas en el pipeline")
                )
        );
        lesson4_2_1.setContent(content4_2_1);
        lessonService.save(lesson4_2_1);

        // Módulo 5: Proyecto Final
        ModuleModel module5 = createModule("Proyecto Final: Workflow Completo",
                "Aplicación de todos los conceptos en un proyecto real",
                "6 hours", 120, 0, false);
        module5.setCourse(gitCourse);
        moduleService.save(module5);

        // Tema 5.1: Proyecto Práctico
        Topic topic5_1 = createTopic("Implementación de Git Flow en Proyecto Real", false);
        topic5_1.setModule(module5);
        topicService.save(topic5_1);

        Lesson lesson5_1_1 = createLesson("Setup y Configuración Inicial", "45 min", false, false);
        lesson5_1_1.setTopic(topic5_1);

        LessonContent content5_1_1 = createLessonContent(
                "https://example.com/videos/git-project-setup",
                "https://example.com/audio/git-project-setup",
                "Proyecto_Final.pdf",
                "git init\ngit flow init\ngit checkout -b develop\ngit push -u origin develop",
                "mindmap-final-project.png",
                "interactive-project-setup",
                Arrays.asList(
                        new CodeExplanation(1, "git init", "Inicializa repositorio Git"),
                        new CodeExplanation(2, "git flow init", "Configura Git Flow con valores por defecto"),
                        new CodeExplanation(3, "git push -u origin develop", "Sube rama develop y establece upstream")
                )
        );
        lesson5_1_1.setContent(content5_1_1);
        lessonService.save(lesson5_1_1);

    }

    //Curso de C++ 
    //-----------------------------------------------------------------------------------------------------------------------
    private void initCppIntroductionModules(Course cppCourse) {
        // ========== MÓDULO 1: FUNDAMENTOS DE PROGRAMACIÓN ==========
        ModuleModel module1 = createModule(
                "Fundamentos de Programación",
                "Introducción a los conceptos básicos de programación, algoritmos y configuración del entorno C++",
                "12 horas", 200, 0, false);
        module1.setCourse(cppCourse);
        moduleService.save(module1);

        // Tema 1.1: Introducción a la Programación
        Topic topic1_1 = createTopic("Introducción a la Programación", false);
        topic1_1.setModule(module1);
        topicService.save(topic1_1);

        // Lección 1.1.1: ¿Qué es la programación?
        Lesson lesson1_1_1 = createLesson("¿Qué es la programación?", "25 min", false, true);
        lesson1_1_1.setTopic(topic1_1);

        LessonContent content1_1_1 = createLessonContent(
                "https://example.com/videos/cpp-intro-programming",
                "https://example.com/audio/cpp-intro-programming-podcast",
                "Introduccion_Programacion.pdf",
                "// La programación es el proceso de crear instrucciones\n// para que una computadora realice tareas específicas\n\n// Ejemplo simple:\ncout << \"¡Hola, bienvenido a la programación!\";",
                "mindmap-programming-concepts.png",
                "interactive-algorithm-thinking",
                Arrays.asList(
                        new CodeExplanation(1, "// Comentarios en C++", "Los comentarios ayudan a documentar el código"),
                        new CodeExplanation(2, "cout << \"mensaje\";", "Instrucción para mostrar texto en pantalla")
                )
        );
        content1_1_1.setLesson(lesson1_1_1);
        lesson1_1_1.setContent(content1_1_1);
        lessonService.save(lesson1_1_1);

        // Lección 1.1.2: Algoritmos y Lógica de Programación
        Lesson lesson1_1_2 = createLesson("Algoritmos y Lógica de Programación", "30 min", false, false);
        lesson1_1_2.setTopic(topic1_1);

        LessonContent content1_1_2 = createLessonContent(
                "https://example.com/videos/cpp-algorithms-logic",
                "https://example.com/audio/cpp-algorithms-logic",
                "Algoritmos_Logica.pdf",
                "// Pseudocódigo: Calcular promedio de 3 números\n// Inicio\n//   Leer num1, num2, num3\n//   promedio = (num1 + num2 + num3) / 3\n//   Mostrar promedio\n// Fin",
                "mindmap-algorithms.png",
                "interactive-flowchart-builder",
                Arrays.asList(
                        new CodeExplanation(1, "Pseudocódigo", "Representación en lenguaje natural de un algoritmo"),
                        new CodeExplanation(2, "Leer datos", "Obtener información del usuario"),
                        new CodeExplanation(3, "Procesar", "Realizar cálculos o transformaciones"),
                        new CodeExplanation(4, "Mostrar resultado", "Presentar el resultado al usuario")
                )
        );
        content1_1_2.setLesson(lesson1_1_2);

        lesson1_1_2.setContent(content1_1_2);
        lessonService.save(lesson1_1_2);

        // Lección 1.1.3: Introducción a C++ y Configuración del Entorno
        Lesson lesson1_1_3 = createLesson("Introducción a C++ y Configuración del Entorno", "35 min", false, false);
        lesson1_1_3.setTopic(topic1_1);

        LessonContent content1_1_3 = createLessonContent(
                "https://example.com/videos/cpp-setup-environment",
                "https://example.com/audio/cpp-setup-environment",
                "Configuracion_Entorno_CPP.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    cout << \"Hello World!\" << endl;\n    return 0;\n}",
                "mindmap-cpp-history.png",
                "interactive-ide-setup",
                Arrays.asList(
                        new CodeExplanation(1, "#include <iostream>", "Incluye la biblioteca de entrada/salida"),
                        new CodeExplanation(2, "using namespace std;", "Permite usar cout sin prefijo std::"),
                        new CodeExplanation(3, "int main()", "Función principal donde inicia el programa"),
                        new CodeExplanation(4, "cout << \"Hello World!\"", "Imprime texto en la consola"),
                        new CodeExplanation(5, "return 0;", "Indica que el programa terminó correctamente")
                )
        );
        content1_1_3.setLesson(lesson1_1_3);

        lesson1_1_3.setContent(content1_1_3);
        lessonService.save(lesson1_1_3);

        // Tema 1.2: Sintaxis Básica de C++
        Topic topic1_2 = createTopic("Sintaxis Básica de C++", false);
        topic1_2.setModule(module1);
        topicService.save(topic1_2);

        // Lección 1.2.1: Estructura de un Programa en C++
        Lesson lesson1_2_1 = createLesson("Estructura de un Programa en C++", "28 min", false, false);
        lesson1_2_1.setTopic(topic1_2);

        LessonContent content1_2_1 = createLessonContent(
                "https://example.com/videos/cpp-program-structure",
                "https://example.com/audio/cpp-program-structure",
                "Estructura_Programa_CPP.pdf",
                "#include <iostream>  // Directiva de preprocesador\nusing namespace std; // Espacio de nombres\n\n// Función principal\nint main() {\n    // Comentario de una línea\n    /* Comentario\n       de múltiples líneas */\n    cout << \"Mi primer programa\" << endl;\n    return 0; // Valor de retorno\n}",
                "mindmap-program-structure.png",
                "interactive-code-anatomy",
                Arrays.asList(
                        new CodeExplanation(1, "#include", "Directiva del preprocesador para incluir bibliotecas"),
                        new CodeExplanation(2, "using namespace std", "Evita escribir std:: antes de cada función"),
                        new CodeExplanation(3, "int main()", "Punto de entrada del programa"),
                        new CodeExplanation(4, "// comentario", "Comentarios para documentar el código"),
                        new CodeExplanation(5, "return 0", "Retorna 0 para indicar ejecución exitosa")
                )
        );
        content1_2_1.setLesson(lesson1_2_1);

        lesson1_2_1.setContent(content1_2_1);
        lessonService.save(lesson1_2_1);

        // Lección 1.2.2: Variables y Tipos de Datos
        Lesson lesson1_2_2 = createLesson("Variables y Tipos de Datos", "32 min", false, false);
        lesson1_2_2.setTopic(topic1_2);

        LessonContent content1_2_2 = createLessonContent(
                "https://example.com/videos/cpp-variables-datatypes",
                "https://example.com/audio/cpp-variables-datatypes",
                "Variables_Tipos_Datos.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Tipos de datos básicos\n    int edad = 25;              // Entero\n    float altura = 1.75;        // Decimal (precisión simple)\n    double precio = 99.99;      // Decimal (doble precisión)\n    char inicial = 'A';         // Carácter\n    bool esEstudiante = true;   // Booleano\n    string nombre = \"Carlos\";   // Cadena de texto\n    \n    cout << \"Edad: \" << edad << endl;\n    cout << \"Altura: \" << altura << endl;\n    cout << \"Precio: \" << precio << endl;\n    cout << \"Inicial: \" << inicial << endl;\n    cout << \"Es estudiante: \" << esEstudiante << endl;\n    cout << \"Nombre: \" << nombre << endl;\n    \n    return 0;\n}",
                "mindmap-data-types.png",
                "interactive-memory-visualization",
                Arrays.asList(
                        new CodeExplanation(1, "int edad = 25", "Declara variable entera e inicializa con 25"),
                        new CodeExplanation(2, "float altura = 1.75", "Número decimal de precisión simple"),
                        new CodeExplanation(3, "double precio = 99.99", "Número decimal de doble precisión"),
                        new CodeExplanation(4, "char inicial = 'A'", "Almacena un solo carácter"),
                        new CodeExplanation(5, "bool esEstudiante = true", "Valor booleano: true o false"),
                        new CodeExplanation(6, "string nombre = \"Carlos\"", "Cadena de texto")
                )
        );
        content1_2_2.setLesson(lesson1_2_2);

        lesson1_2_2.setContent(content1_2_2);
        lessonService.save(lesson1_2_2);

        // Lección 1.2.3: Operadores Aritméticos y de Asignación
        Lesson lesson1_2_3 = createLesson("Operadores Aritméticos y de Asignación", "30 min", false, false);
        lesson1_2_3.setTopic(topic1_2);

        LessonContent content1_2_3 = createLessonContent(
                "https://example.com/videos/cpp-operators",
                "https://example.com/audio/cpp-operators",
                "Operadores_CPP.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    int a = 10, b = 3;\n    \n    // Operadores aritméticos\n    cout << \"Suma: \" << (a + b) << endl;         // 13\n    cout << \"Resta: \" << (a - b) << endl;        // 7\n    cout << \"Multiplicación: \" << (a * b) << endl; // 30\n    cout << \"División: \" << (a / b) << endl;     // 3 (división entera)\n    cout << \"Módulo: \" << (a % b) << endl;       // 1 (residuo)\n    \n    // Operadores de incremento/decremento\n    int x = 5;\n    x++;  // x = 6\n    x--;  // x = 5\n    \n    // Operadores de asignación compuesta\n    int y = 10;\n    y += 5;  // y = 15 (equivale a y = y + 5)\n    y *= 2;  // y = 30 (equivale a y = y * 2)\n    \n    cout << \"Resultado final: \" << y << endl;\n    \n    return 0;\n}",
                "mindmap-operators.png",
                "interactive-operator-calculator",
                Arrays.asList(
                        new CodeExplanation(1, "a + b", "Suma de dos valores"),
                        new CodeExplanation(2, "a - b", "Resta de dos valores"),
                        new CodeExplanation(3, "a * b", "Multiplicación"),
                        new CodeExplanation(4, "a / b", "División (entera si ambos son int)"),
                        new CodeExplanation(5, "a % b", "Módulo (resto de la división)"),
                        new CodeExplanation(6, "x++", "Incrementa x en 1"),
                        new CodeExplanation(7, "y += 5", "Suma 5 a y (asignación compuesta)")
                )
        );
        content1_2_3.setLesson(lesson1_2_3);

        lesson1_2_3.setContent(content1_2_3);
        lessonService.save(lesson1_2_3);

        // ========== MÓDULO 2: ESTRUCTURAS DE CONTROL ==========
        ModuleModel module2 = createModule(
                "Estructuras de Control",
                "Domina condicionales, operadores lógicos y ciclos para controlar el flujo de tus programas",
                "14 horas", 250, 0, false);
        module2.setCourse(cppCourse);
        moduleService.save(module2);

        // Tema 2.1: Condicionales
        Topic topic2_1 = createTopic("Condicionales", false);
        topic2_1.setModule(module2);
        topicService.save(topic2_1);

        // Lección 2.1.1: Estructura if-else
        Lesson lesson2_1_1 = createLesson("Estructura if-else", "28 min", false, false);
        lesson2_1_1.setTopic(topic2_1);

        LessonContent content2_1_1 = createLessonContent(
                "https://example.com/videos/cpp-if-else",
                "https://example.com/audio/cpp-if-else",
                "Estructura_If_Else.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    int edad;\n    cout << \"Ingrese su edad: \";\n    cin >> edad;\n    \n    // if-else simple\n    if (edad >= 18) {\n        cout << \"Eres mayor de edad\" << endl;\n    } else {\n        cout << \"Eres menor de edad\" << endl;\n    }\n    \n    // if-else if-else anidado\n    int calificacion;\n    cout << \"Ingrese calificación (0-100): \";\n    cin >> calificacion;\n    \n    if (calificacion >= 90) {\n        cout << \"Excelente\" << endl;\n    } else if (calificacion >= 70) {\n        cout << \"Bueno\" << endl;\n    } else if (calificacion >= 50) {\n        cout << \"Aprobado\" << endl;\n    } else {\n        cout << \"Reprobado\" << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-if-else.png",
                "interactive-flowchart-if",
                Arrays.asList(
                        new CodeExplanation(1, "if (condicion)", "Evalúa si la condición es verdadera"),
                        new CodeExplanation(2, "else", "Ejecuta si la condición del if es falsa"),
                        new CodeExplanation(3, "else if", "Evalúa condiciones adicionales"),
                        new CodeExplanation(4, "cin >> variable", "Lee entrada del usuario")
                )
        );
        content2_1_1.setLesson(lesson2_1_1);

        lesson2_1_1.setContent(content2_1_1);
        lessonService.save(lesson2_1_1);

        // Lección 2.1.2: Operadores Relacionales y Lógicos
        Lesson lesson2_1_2 = createLesson("Operadores Relacionales y Lógicos", "25 min", false, false);
        lesson2_1_2.setTopic(topic2_1);

        LessonContent content2_1_2 = createLessonContent(
                "https://example.com/videos/cpp-logical-operators",
                "https://example.com/audio/cpp-logical-operators",
                "Operadores_Logicos.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    int edad = 25;\n    bool tieneLicencia = true;\n    \n    // Operadores relacionales\n    bool mayorDeEdad = (edad >= 18);  // true\n    bool esIgual = (edad == 25);       // true\n    bool esDiferente = (edad != 30);   // true\n    \n    // Operadores lógicos\n    // AND (&&) - Ambas condiciones deben ser verdaderas\n    if (edad >= 18 && tieneLicencia) {\n        cout << \"Puede conducir\" << endl;\n    }\n    \n    // OR (||) - Al menos una condición debe ser verdadera\n    if (edad < 18 || !tieneLicencia) {\n        cout << \"No puede conducir\" << endl;\n    }\n    \n    // NOT (!) - Invierte el valor booleano\n    if (!tieneLicencia) {\n        cout << \"Debe obtener licencia\" << endl;\n    }\n    \n    // Combinación de operadores\n    int hora = 14;\n    if ((hora >= 12 && hora < 18) || (edad > 21)) {\n        cout << \"Horario válido\" << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-logical-operators.png",
                "interactive-truth-tables",
                Arrays.asList(
                        new CodeExplanation(1, "==", "Igual a"),
                        new CodeExplanation(2, "!=", "Diferente de"),
                        new CodeExplanation(3, "< <= > >=", "Menor, menor o igual, mayor, mayor o igual"),
                        new CodeExplanation(4, "&&", "AND lógico - ambas condiciones verdaderas"),
                        new CodeExplanation(5, "||", "OR lógico - al menos una condición verdadera"),
                        new CodeExplanation(6, "!", "NOT lógico - invierte el valor booleano")
                )
        );
        content2_1_2.setLesson(lesson2_1_2);

        lesson2_1_2.setContent(content2_1_2);
        lessonService.save(lesson2_1_2);

        // Lección 2.1.3: Switch-Case
        Lesson lesson2_1_3 = createLesson("Switch-Case", "22 min", false, false);
        lesson2_1_3.setTopic(topic2_1);

        LessonContent content2_1_3 = createLessonContent(
                "https://example.com/videos/cpp-switch-case",
                "https://example.com/audio/cpp-switch-case",
                "Switch_Case.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    int opcion;\n    cout << \"=== MENÚ PRINCIPAL ===\" << endl;\n    cout << \"1. Nuevo juego\" << endl;\n    cout << \"2. Cargar partida\" << endl;\n    cout << \"3. Opciones\" << endl;\n    cout << \"4. Salir\" << endl;\n    cout << \"Seleccione una opción: \";\n    cin >> opcion;\n    \n    switch(opcion) {\n        case 1:\n            cout << \"Iniciando nuevo juego...\" << endl;\n            break;\n        case 2:\n            cout << \"Cargando partida...\" << endl;\n            break;\n        case 3:\n            cout << \"Abriendo opciones...\" << endl;\n            break;\n        case 4:\n            cout << \"Saliendo del juego...\" << endl;\n            break;\n        default:\n            cout << \"Opción inválida\" << endl;\n    }\n    \n    // Ejemplo: Días de la semana\n    int dia = 3;\n    switch(dia) {\n        case 1: cout << \"Lunes\"; break;\n        case 2: cout << \"Martes\"; break;\n        case 3: cout << \"Miércoles\"; break;\n        case 4: cout << \"Jueves\"; break;\n        case 5: cout << \"Viernes\"; break;\n        case 6:\n        case 7:\n            cout << \"Fin de semana\"; break;\n        default:\n            cout << \"Día inválido\";\n    }\n    \n    return 0;\n}",
                "mindmap-switch-case.png",
                "interactive-menu-builder",
                Arrays.asList(
                        new CodeExplanation(1, "switch(variable)", "Evalúa el valor de la variable"),
                        new CodeExplanation(2, "case valor:", "Define un caso específico"),
                        new CodeExplanation(3, "break;", "Sale del switch (importante para evitar fall-through)"),
                        new CodeExplanation(4, "default:", "Se ejecuta si ningún caso coincide"),
                        new CodeExplanation(5, "case 6: case 7:", "Múltiples casos pueden compartir código")
                )
        );
        content2_1_3.setLesson(lesson2_1_3);

        lesson2_1_3.setContent(content2_1_3);
        lessonService.save(lesson2_1_3);

        // Tema 2.2: Ciclos e Iteraciones
        Topic topic2_2 = createTopic("Ciclos e Iteraciones", false);
        topic2_2.setModule(module2);
        topicService.save(topic2_2);

        // Lección 2.2.1: Ciclo While
        Lesson lesson2_2_1 = createLesson("Ciclo While", "26 min", false, false);
        lesson2_2_1.setTopic(topic2_2);

        LessonContent content2_2_1 = createLessonContent(
                "https://example.com/videos/cpp-while-loop",
                "https://example.com/audio/cpp-while-loop",
                "Ciclo_While.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Ejemplo 1: Contador simple\n    int contador = 1;\n    while (contador <= 5) {\n        cout << \"Iteración: \" << contador << endl;\n        contador++;\n    }\n    \n    // Ejemplo 2: Sumar números hasta que el usuario ingrese 0\n    int numero, suma = 0;\n    cout << \"Ingrese números (0 para terminar):\" << endl;\n    cin >> numero;\n    \n    while (numero != 0) {\n        suma += numero;\n        cout << \"Suma actual: \" << suma << endl;\n        cout << \"Ingrese otro número: \";\n        cin >> numero;\n    }\n    cout << \"Suma total: \" << suma << endl;\n    \n    // Ejemplo 3: Validación de entrada\n    int edad;\n    cout << \"Ingrese edad (1-120): \";\n    cin >> edad;\n    \n    while (edad < 1 || edad > 120) {\n        cout << \"Edad inválida. Intente nuevamente: \";\n        cin >> edad;\n    }\n    cout << \"Edad válida: \" << edad << endl;\n    \n    return 0;\n}",
                "mindmap-while-loop.png",
                "interactive-while-visualizer",
                Arrays.asList(
                        new CodeExplanation(1, "while (condicion)", "Repite mientras la condición sea verdadera"),
                        new CodeExplanation(2, "contador++", "Incrementa el contador en cada iteración"),
                        new CodeExplanation(3, "suma += numero", "Acumula valores en la variable suma"),
                        new CodeExplanation(4, "while (validacion)", "Útil para validar entrada del usuario")
                )
        );
        content2_2_1.setLesson(lesson2_2_1);

        lesson2_2_1.setContent(content2_2_1);
        lessonService.save(lesson2_2_1);

        // Lección 2.2.2: Ciclo Do-While
        Lesson lesson2_2_2 = createLesson("Ciclo Do-While", "20 min", false, false);
        lesson2_2_2.setTopic(topic2_2);

        LessonContent content2_2_2 = createLessonContent(
                "https://example.com/videos/cpp-do-while-loop",
                "https://example.com/audio/cpp-do-while-loop",
                "Ciclo_Do_While.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Diferencia clave: do-while se ejecuta al menos una vez\n    int opcion;\n    \n    do {\n        cout << \"\\n=== MENÚ ===\" << endl;\n        cout << \"1. Opción A\" << endl;\n        cout << \"2. Opción B\" << endl;\n        cout << \"3. Opción C\" << endl;\n        cout << \"0. Salir\" << endl;\n        cout << \"Seleccione: \";\n        cin >> opcion;\n        \n        switch(opcion) {\n            case 1:\n                cout << \"Ejecutando opción A\" << endl;\n                break;\n            case 2:\n                cout << \"Ejecutando opción B\" << endl;\n                break;\n            case 3:\n                cout << \"Ejecutando opción C\" << endl;\n                break;\n            case 0:\n                cout << \"¡Hasta luego!\" << endl;\n                break;\n            default:\n                cout << \"Opción inválida\" << endl;\n        }\n    } while (opcion != 0);\n    \n    // Ejemplo 2: Validación de contraseña\n    string password;\n    do {\n        cout << \"Ingrese contraseña (min 6 caracteres): \";\n        cin >> password;\n        if (password.length() < 6) {\n            cout << \"Contraseña muy corta\" << endl;\n        }\n    } while (password.length() < 6);\n    \n    cout << \"Contraseña aceptada\" << endl;\n    \n    return 0;\n}",
                "mindmap-do-while-loop.png",
                "interactive-do-while-comparison",
                Arrays.asList(
                        new CodeExplanation(1, "do { ... } while (condicion)", "Ejecuta el bloque al menos una vez"),
                        new CodeExplanation(2, "Diferencia con while", "do-while evalúa la condición al final"),
                        new CodeExplanation(3, "Uso ideal", "Menús y validaciones que requieren ejecutarse al menos una vez")
                )
        );
        content2_2_2.setLesson(lesson2_2_2);

        lesson2_2_2.setContent(content2_2_2);
        lessonService.save(lesson2_2_2);

        // Lección 2.2.3: Ciclo For
        Lesson lesson2_2_3 = createLesson("Ciclo For", "28 min", false, false);
        lesson2_2_3.setTopic(topic2_2);

        LessonContent content2_2_3 = createLessonContent(
                "https://example.com/videos/cpp-for-loop",
                "https://example.com/audio/cpp-for-loop",
                "Ciclo_For.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Ejemplo 1: Contar del 1 al 10\n    for (int i = 1; i <= 10; i++) {\n        cout << i << \" \";\n    }\n    cout << endl;\n    \n    // Ejemplo 2: Tabla de multiplicar\n    int numero = 7;\n    cout << \"Tabla del \" << numero << \":\" << endl;\n    for (int i = 1; i <= 10; i++) {\n        cout << numero << \" x \" << i << \" = \" << (numero * i) << endl;\n    }\n    \n    // Ejemplo 3: Sumar números del 1 al 100\n    int suma = 0;\n    for (int i = 1; i <= 100; i++) {\n        suma += i;\n    }\n    cout << \"Suma del 1 al 100: \" << suma << endl;\n    \n    // Ejemplo 4: Contar hacia atrás\n    cout << \"Cuenta regresiva: \";\n    for (int i = 10; i >= 0; i--) {\n        cout << i << \" \";\n    }\n    cout << \"¡Despegue!\" << endl;\n    \n    // Ejemplo 5: Incrementos personalizados\n    cout << \"Números pares del 2 al 20: \";\n    for (int i = 2; i <= 20; i += 2) {\n        cout << i << \" \";\n    }\n    cout << endl;\n    \n    return 0;\n}",
                "mindmap-for-loop.png",
                "interactive-for-visualizer",
                Arrays.asList(
                        new CodeExplanation(1, "for (inicialización; condición; incremento)", "Estructura completa del for"),
                        new CodeExplanation(2, "int i = 1", "Inicialización: se ejecuta una sola vez al inicio"),
                        new CodeExplanation(3, "i <= 10", "Condición: se evalúa antes de cada iteración"),
                        new CodeExplanation(4, "i++", "Incremento: se ejecuta al final de cada iteración"),
                        new CodeExplanation(5, "i += 2", "Incrementos personalizados para saltos mayores")
                )
        );

        lesson2_2_3.setContent(content2_2_3);
        lessonService.save(lesson2_2_3);

        // Lección 2.2.4: Ciclos Anidados
        Lesson lesson2_2_4 = createLesson("Ciclos Anidados", "30 min", false, false);
        lesson2_2_4.setTopic(topic2_2);

        LessonContent content2_2_4 = createLessonContent(
                "https://example.com/videos/cpp-nested-loops",
                "https://example.com/audio/cpp-nested-loops",
                "Ciclos_Anidados.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Ejemplo 1: Tabla de multiplicar completa\n    cout << \"Tablas de multiplicar del 1 al 5:\" << endl;\n    for (int tabla = 1; tabla <= 5; tabla++) {\n        cout << \"\\nTabla del \" << tabla << \":\" << endl;\n        for (int num = 1; num <= 10; num++) {\n            cout << tabla << \" x \" << num << \" = \" << (tabla * num) << endl;\n        }\n    }\n    \n    // Ejemplo 2: Patrón de asteriscos (triángulo)\n    cout << \"\\nTriángulo de asteriscos:\" << endl;\n    for (int fila = 1; fila <= 5; fila++) {\n        for (int col = 1; col <= fila; col++) {\n            cout << \"* \";\n        }\n        cout << endl;\n    }\n    \n    // Ejemplo 3: Cuadrado de números\n    cout << \"\\nCuadrado de números:\" << endl;\n    for (int i = 1; i <= 4; i++) {\n        for (int j = 1; j <= 4; j++) {\n            cout << (i * j) << \"\\t\";\n        }\n        cout << endl;\n    }\n    \n    // Ejemplo 4: Pirámide centrada\n    int altura = 5;\n    cout << \"\\nPirámide centrada:\" << endl;\n    for (int i = 1; i <= altura; i++) {\n        // Espacios\n        for (int esp = 1; esp <= altura - i; esp++) {\n            cout << \" \";\n        }\n        // Asteriscos\n        for (int ast = 1; ast <= 2 * i - 1; ast++) {\n            cout << \"*\";\n        }\n        cout << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-nested-loops.png",
                "interactive-pattern-generator",
                Arrays.asList(
                        new CodeExplanation(1, "for (externo) { for (interno) { } }", "Ciclo dentro de otro ciclo"),
                        new CodeExplanation(2, "Ciclo externo", "Controla las filas o iteraciones principales"),
                        new CodeExplanation(3, "Ciclo interno", "Se ejecuta completamente en cada iteración del externo"),
                        new CodeExplanation(4, "Complejidad", "Cuidado: ciclos anidados aumentan el tiempo de ejecución"),
                        new CodeExplanation(5, "Patrones", "Útiles para crear patrones, matrices y tablas")
                )
        );
        content2_2_4.setLesson(lesson2_2_4);

        lesson2_2_4.setContent(content2_2_4);
        lessonService.save(lesson2_2_4);

        // ========== MÓDULO 3: FUNCIONES Y MODULARIZACIÓN ==========
        ModuleModel module3 = createModule(
                "Funciones y Modularización",
                "Aprende a crear funciones reutilizables, manejo de parámetros, referencias y recursividad",
                "12 horas", 300, 0, false);
        module3.setCourse(cppCourse);
        moduleService.save(module3);

        // Tema 3.1: Introducción a Funciones
        Topic topic3_1 = createTopic("Introducción a Funciones", false);
        topic3_1.setModule(module3);
        topicService.save(topic3_1);

        // Lección 3.1.1: Definición y Llamada de Funciones
        Lesson lesson3_1_1 = createLesson("Definición y Llamada de Funciones", "30 min", false, false);
        lesson3_1_1.setTopic(topic3_1);

        LessonContent content3_1_1 = createLessonContent(
                "https://example.com/videos/cpp-functions-intro",
                "https://example.com/audio/cpp-functions-intro",
                "Introduccion_Funciones.pdf",
                "#include <iostream>\nusing namespace std;\n\n// Prototipo de función (declaración)\nvoid saludar();\nint sumar(int a, int b);\ndouble calcularPromedio(double n1, double n2, double n3);\n\nint main() {\n    // Llamadas a funciones\n    saludar();\n    \n    int resultado = sumar(10, 20);\n    cout << \"Suma: \" << resultado << endl;\n    \n    double promedio = calcularPromedio(8.5, 9.0, 7.5);\n    cout << \"Promedio: \" << promedio << endl;\n    \n    return 0;\n}\n\n// Implementación de funciones\nvoid saludar() {\n    cout << \"¡Hola desde la función!\" << endl;\n}\n\nint sumar(int a, int b) {\n    return a + b;\n}\n\ndouble calcularPromedio(double n1, double n2, double n3) {\n    return (n1 + n2 + n3) / 3.0;\n}",
                "mindmap-functions.png",
                "interactive-function-builder",
                Arrays.asList(
                        new CodeExplanation(1, "void saludar()", "Función sin valor de retorno"),
                        new CodeExplanation(2, "int sumar(int a, int b)", "Función que retorna entero y recibe parámetros"),
                        new CodeExplanation(3, "Prototipo", "Declaración antes de main() para informar al compilador"),
                        new CodeExplanation(4, "return", "Devuelve un valor al punto donde se llamó la función"),
                        new CodeExplanation(5, "Modularización", "Divide el código en partes reutilizables")
                )
        );
        content3_1_1.setLesson(lesson3_1_1);

        lesson3_1_1.setContent(content3_1_1);
        lessonService.save(lesson3_1_1);

        // Lección 3.1.2: Parámetros y Argumentos
        Lesson lesson3_1_2 = createLesson("Parámetros y Argumentos", "25 min", false, false);
        lesson3_1_2.setTopic(topic3_1);

        LessonContent content3_1_2 = createLessonContent(
                "https://example.com/videos/cpp-parameters",
                "https://example.com/audio/cpp-parameters",
                "Parametros_Argumentos.pdf",
                "#include <iostream>\nusing namespace std;\n\n// Función con múltiples parámetros\nvoid mostrarDatos(string nombre, int edad, double altura) {\n    cout << \"Nombre: \" << nombre << endl;\n    cout << \"Edad: \" << edad << \" años\" << endl;\n    cout << \"Altura: \" << altura << \" m\" << endl;\n}\n\n// Función con parámetros por defecto\nvoid configurar(string modo = \"básico\", int nivel = 1) {\n    cout << \"Modo: \" << modo << \", Nivel: \" << nivel << endl;\n}\n\n// Función que calcula el área de un rectángulo\ndouble calcularArea(double base, double altura) {\n    return base * altura;\n}\n\nint main() {\n    // Llamadas con argumentos\n    mostrarDatos(\"Carlos\", 25, 1.75);\n    mostrarDatos(\"Ana\", 30, 1.65);\n    \n    // Usando valores por defecto\n    configurar();                    // básico, 1\n    configurar(\"avanzado\");          // avanzado, 1\n    configurar(\"experto\", 5);        // experto, 5\n    \n    // Calculando áreas\n    double area1 = calcularArea(5.0, 3.0);\n    double area2 = calcularArea(10.0, 7.5);\n    cout << \"Área 1: \" << area1 << endl;\n    cout << \"Área 2: \" << area2 << endl;\n    \n    return 0;\n}",
                "mindmap-parameters.png",
                "interactive-parameter-visualizer",
                Arrays.asList(
                        new CodeExplanation(1, "Parámetros", "Variables en la definición de la función"),
                        new CodeExplanation(2, "Argumentos", "Valores reales pasados al llamar la función"),
                        new CodeExplanation(3, "Valores por defecto", "Parámetros opcionales con valores predeterminados"),
                        new CodeExplanation(4, "Paso por valor", "Se copia el valor del argumento al parámetro")
                )
        );
        content3_1_2.setLesson(lesson3_1_2);

        lesson3_1_2.setContent(content3_1_2);
        lessonService.save(lesson3_1_2);

        // Lección 3.1.3: Retorno de Valores
        Lesson lesson3_1_3 = createLesson("Retorno de Valores", "22 min", false, false);
        lesson3_1_3.setTopic(topic3_1);

        LessonContent content3_1_3 = createLessonContent(
                "https://example.com/videos/cpp-return-values",
                "https://example.com/audio/cpp-return-values",
                "Retorno_Valores.pdf",
                "#include <iostream>\n#include <cmath>\nusing namespace std;\n\n// Función que retorna entero\nint factorial(int n) {\n    int resultado = 1;\n    for (int i = 1; i <= n; i++) {\n        resultado *= i;\n    }\n    return resultado;\n}\n\n// Función que retorna booleano\nbool esPar(int numero) {\n    return (numero % 2 == 0);\n}\n\n// Función con retorno anticipado\nint dividir(int a, int b) {\n    if (b == 0) {\n        cout << \"Error: división por cero\" << endl;\n        return -1;  // Retorno anticipado\n    }\n    return a / b;\n}\n\n// Función que retorna el mayor de tres números\nint mayor(int a, int b, int c) {\n    if (a >= b && a >= c) return a;\n    if (b >= a && b >= c) return b;\n    return c;\n}\n\nint main() {\n    // Usando funciones que retornan valores\n    int fact = factorial(5);\n    cout << \"5! = \" << fact << endl;\n    \n    if (esPar(10)) {\n        cout << \"10 es par\" << endl;\n    }\n    \n    int resultado = dividir(20, 4);\n    cout << \"20 / 4 = \" << resultado << endl;\n    \n    int max = mayor(15, 8, 23);\n    cout << \"El mayor es: \" << max << endl;\n    \n    return 0;\n}",
                "mindmap-return-values.png",
                "interactive-return-flow",
                Arrays.asList(
                        new CodeExplanation(1, "return valor", "Devuelve el valor al punto de llamada"),
                        new CodeExplanation(2, "Tipo de retorno", "Debe coincidir con la declaración de la función"),
                        new CodeExplanation(3, "Retorno anticipado", "return dentro de un if para salir antes"),
                        new CodeExplanation(4, "void", "Funciones sin retorno de valor")
                )
        );
        content3_1_3.setLesson(lesson3_1_3);

        lesson3_1_3.setContent(content3_1_3);
        lessonService.save(lesson3_1_3);

        // Tema 3.2: Conceptos Avanzados de Funciones
        Topic topic3_2 = createTopic("Conceptos Avanzados de Funciones", false);
        topic3_2.setModule(module3);
        topicService.save(topic3_2);

        // Lección 3.2.1: Paso por Referencia
        Lesson lesson3_2_1 = createLesson("Paso por Referencia", "28 min", false, false);
        lesson3_2_1.setTopic(topic3_2);

        LessonContent content3_2_1 = createLessonContent(
                "https://example.com/videos/cpp-pass-by-reference",
                "https://example.com/audio/cpp-pass-by-reference",
                "Paso_Por_Referencia.pdf",
                "#include <iostream>\nusing namespace std;\n\n// Paso por valor (no modifica el original)\nvoid incrementarPorValor(int x) {\n    x = x + 10;\n    cout << \"Dentro función (valor): \" << x << endl;\n}\n\n// Paso por referencia (modifica el original)\nvoid incrementarPorReferencia(int &x) {\n    x = x + 10;\n    cout << \"Dentro función (referencia): \" << x << endl;\n}\n\n// Función swap usando referencias\nvoid intercambiar(int &a, int &b) {\n    int temp = a;\n    a = b;\n    b = temp;\n}\n\n// Función que modifica múltiples valores\nvoid calcularOperaciones(int a, int b, int &suma, int &producto) {\n    suma = a + b;\n    producto = a * b;\n}\n\nint main() {\n    // Demostrando paso por valor\n    int num1 = 5;\n    cout << \"Antes (valor): \" << num1 << endl;\n    incrementarPorValor(num1);\n    cout << \"Después (valor): \" << num1 << endl;  // Sigue siendo 5\n    \n    cout << endl;\n    \n    // Demostrando paso por referencia\n    int num2 = 5;\n    cout << \"Antes (referencia): \" << num2 << endl;\n    incrementarPorReferencia(num2);\n    cout << \"Después (referencia): \" << num2 << endl;  // Ahora es 15\n    \n    cout << endl;\n    \n    // Usando swap\n    int x = 10, y = 20;\n    cout << \"Antes del swap: x=\" << x << \", y=\" << y << endl;\n    intercambiar(x, y);\n    cout << \"Después del swap: x=\" << x << \", y=\" << y << endl;\n    \n    // Retornando múltiples valores\n    int s, p;\n    calcularOperaciones(5, 3, s, p);\n    cout << \"Suma: \" << s << \", Producto: \" << p << endl;\n    \n    return 0;\n}",
                "mindmap-pass-by-reference.png",
                "interactive-memory-reference",
                Arrays.asList(
                        new CodeExplanation(1, "int x", "Paso por valor - se copia el valor"),
                        new CodeExplanation(2, "int &x", "Paso por referencia - se pasa la dirección"),
                        new CodeExplanation(3, "Modificación", "Las referencias permiten modificar el valor original"),
                        new CodeExplanation(4, "Eficiencia", "Referencias evitan copiar datos grandes"),
                        new CodeExplanation(5, "Múltiples retornos", "Útil para retornar varios valores")
                )
        );
        content3_2_1.setLesson(lesson3_2_1);

        lesson3_2_1.setContent(content3_2_1);
        lessonService.save(lesson3_2_1);

        // Lección 3.2.2: Sobrecarga de Funciones
        Lesson lesson3_2_2 = createLesson("Sobrecarga de Funciones", "24 min", false, false);
        lesson3_2_2.setTopic(topic3_2);

        LessonContent content3_2_2 = createLessonContent(
                "https://example.com/videos/cpp-function-overloading",
                "https://example.com/audio/cpp-function-overloading",
                "Sobrecarga_Funciones.pdf",
                "#include <iostream>\nusing namespace std;\n\n// Sobrecarga: mismo nombre, diferentes parámetros\n\n// Sumar dos enteros\nint sumar(int a, int b) {\n    cout << \"Sumando enteros\" << endl;\n    return a + b;\n}\n\n// Sumar tres enteros\nint sumar(int a, int b, int c) {\n    cout << \"Sumando tres enteros\" << endl;\n    return a + b + c;\n}\n\n// Sumar dos doubles\ndouble sumar(double a, double b) {\n    cout << \"Sumando doubles\" << endl;\n    return a + b;\n}\n\n// Calcular área - diferentes figuras\ndouble calcularArea(double radio) {\n    // Área del círculo\n    return 3.14159 * radio * radio;\n}\n\ndouble calcularArea(double base, double altura) {\n    // Área del rectángulo\n    return base * altura;\n}\n\ndouble calcularArea(double base, double altura, bool esTriangulo) {\n    // Área del triángulo\n    if (esTriangulo) {\n        return (base * altura) / 2.0;\n    }\n    return base * altura;\n}\n\nint main() {\n    // El compilador elige la función correcta según los argumentos\n    cout << sumar(5, 3) << endl;           // Llama a sumar(int, int)\n    cout << sumar(5, 3, 2) << endl;        // Llama a sumar(int, int, int)\n    cout << sumar(5.5, 3.2) << endl;       // Llama a sumar(double, double)\n    \n    cout << \"\\nÁreas:\" << endl;\n    cout << \"Círculo (r=5): \" << calcularArea(5.0) << endl;\n    cout << \"Rectángulo (5x3): \" << calcularArea(5.0, 3.0) << endl;\n    cout << \"Triángulo (5x3): \" << calcularArea(5.0, 3.0, true) << endl;\n    \n    return 0;\n}",
                "mindmap-function-overloading.png",
                "interactive-overload-selector",
                Arrays.asList(
                        new CodeExplanation(1, "Sobrecarga", "Múltiples funciones con el mismo nombre"),
                        new CodeExplanation(2, "Firma diferente", "Deben diferir en número o tipo de parámetros"),
                        new CodeExplanation(3, "Resolución", "El compilador elige la función correcta"),
                        new CodeExplanation(4, "No por retorno", "El tipo de retorno solo no es suficiente para sobrecargar")
                )
        );
        content3_2_2.setLesson(lesson3_2_2);

        lesson3_2_2.setContent(content3_2_2);
        lessonService.save(lesson3_2_2);

        // Lección 3.2.3: Recursividad
        Lesson lesson3_2_3 = createLesson("Recursividad", "32 min", false, false);
        lesson3_2_3.setTopic(topic3_2);

        LessonContent content3_2_3 = createLessonContent(
                "https://example.com/videos/cpp-recursion",
                "https://example.com/audio/cpp-recursion",
                "Recursividad.pdf",
                "#include <iostream>\nusing namespace std;\n\n// Factorial recursivo\nint factorial(int n) {\n    // Caso base\n    if (n == 0 || n == 1) {\n        return 1;\n    }\n    // Caso recursivo\n    return n * factorial(n - 1);\n}\n\n// Fibonacci recursivo\nint fibonacci(int n) {\n    if (n <= 1) {\n        return n;\n    }\n    return fibonacci(n - 1) + fibonacci(n - 2);\n}\n\n// Suma de dígitos recursiva\nint sumaDigitos(int n) {\n    if (n == 0) {\n        return 0;\n    }\n    return (n % 10) + sumaDigitos(n / 10);\n}\n\n// Potencia recursiva\nint potencia(int base, int exponente) {\n    if (exponente == 0) {\n        return 1;\n    }\n    return base * potencia(base, exponente - 1);\n}\n\n// Contar hacia atrás recursivamente\nvoid cuentaRegresiva(int n) {\n    if (n < 0) {\n        return;\n    }\n    cout << n << \" \";\n    cuentaRegresiva(n - 1);\n}\n\nint main() {\n    // Factorial\n    cout << \"5! = \" << factorial(5) << endl;\n    \n    // Fibonacci\n    cout << \"Fibonacci(7) = \" << fibonacci(7) << endl;\n    \n    // Suma de dígitos\n    cout << \"Suma dígitos de 12345: \" << sumaDigitos(12345) << endl;\n    \n    // Potencia\n    cout << \"2^5 = \" << potencia(2, 5) << endl;\n    \n    // Cuenta regresiva\n    cout << \"Cuenta regresiva desde 10: \";\n    cuentaRegresiva(10);\n    cout << endl;\n    \n    return 0;\n}",
                "mindmap-recursion.png",
                "interactive-recursion-tree",
                Arrays.asList(
                        new CodeExplanation(1, "Recursividad", "Función que se llama a sí misma"),
                        new CodeExplanation(2, "Caso base", "Condición de parada (ESENCIAL)"),
                        new CodeExplanation(3, "Caso recursivo", "Llamada a la misma función con parámetros diferentes"),
                        new CodeExplanation(4, "Stack", "Cada llamada se apila en memoria"),
                        new CodeExplanation(5, "Cuidado", "Sin caso base causa desbordamiento de pila")
                )
        );
        content3_2_3.setLesson(lesson3_2_3);

        lesson3_2_3.setContent(content3_2_3);
        lessonService.save(lesson3_2_3);

        // ========== MÓDULO 4: ARREGLOS Y VECTORES ==========
        ModuleModel module4 = createModule(
                "Arreglos y Vectores",
                "Manejo de colecciones de datos con arreglos estáticos, matrices y vectores dinámicos",
                "14 horas", 350, 0, false);
        module4.setCourse(cppCourse);
        moduleService.save(module4);

        // Tema 4.1: Arreglos Unidimensionales
        Topic topic4_1 = createTopic("Arreglos Unidimensionales", false);
        topic4_1.setModule(module4);
        topicService.save(topic4_1);

        // Lección 4.1.1: Declaración e Inicialización de Arreglos
        Lesson lesson4_1_1 = createLesson("Declaración e Inicialización de Arreglos", "26 min", false, false);
        lesson4_1_1.setTopic(topic4_1);

        LessonContent content4_1_1 = createLessonContent(
                "https://example.com/videos/cpp-arrays-intro",
                "https://example.com/audio/cpp-arrays-intro",
                "Arrays_Introduccion.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Declaración e inicialización\n    int numeros[5] = {10, 20, 30, 40, 50};\n    \n    // Declaración sin inicializar\n    int edades[3];\n    edades[0] = 18;\n    edades[1] = 25;\n    edades[2] = 30;\n    \n    // Inicialización parcial (resto se llena con 0)\n    int valores[5] = {1, 2};  // {1, 2, 0, 0, 0}\n    \n    // El compilador calcula el tamaño\n    double precios[] = {19.99, 29.99, 39.99, 49.99};\n    \n    // Acceso a elementos (índices empiezan en 0)\n    cout << \"Primer número: \" << numeros[0] << endl;\n    cout << \"Último número: \" << numeros[4] << endl;\n    \n    // Modificar elementos\n    numeros[2] = 100;\n    cout << \"Número modificado: \" << numeros[2] << endl;\n    \n    // Mostrar todos los elementos\n    cout << \"\\nTodos los números:\" << endl;\n    for (int i = 0; i < 5; i++) {\n        cout << \"numeros[\" << i << \"] = \" << numeros[i] << endl;\n    }\n    \n    // Tamaño del arreglo\n    int tamanio = sizeof(numeros) / sizeof(numeros[0]);\n    cout << \"\\nTamaño del arreglo: \" << tamanio << endl;\n    \n    return 0;\n}",
                "mindmap-arrays.png",
                "interactive-array-memory",
                Arrays.asList(
                        new CodeExplanation(1, "int numeros[5]", "Declara arreglo de 5 enteros"),
                        new CodeExplanation(2, "{10, 20, 30}", "Inicialización con lista de valores"),
                        new CodeExplanation(3, "numeros[0]", "Acceso por índice (comienza en 0)"),
                        new CodeExplanation(4, "Tamaño fijo", "El tamaño debe conocerse en compilación"),
                        new CodeExplanation(5, "sizeof()", "Calcula bytes del arreglo")
                )
        );
        content4_1_1.setLesson(lesson4_1_1);

        lesson4_1_1.setContent(content4_1_1);
        lessonService.save(lesson4_1_1);

        // Lección 4.1.2: Recorrido y Manipulación de Arreglos
        Lesson lesson4_1_2 = createLesson("Recorrido y Manipulación de Arreglos", "30 min", false, false);
        lesson4_1_2.setTopic(topic4_1);

        LessonContent content4_1_2 = createLessonContent(
                "https://example.com/videos/cpp-array-manipulation",
                "https://example.com/audio/cpp-array-manipulation",
                "Manipulacion_Arrays.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    const int TAM = 5;\n    int calificaciones[TAM] = {85, 92, 78, 95, 88};\n    \n    // Recorrido y mostrar\n    cout << \"Calificaciones:\" << endl;\n    for (int i = 0; i < TAM; i++) {\n        cout << \"Estudiante \" << (i+1) << \":\" << calificaciones[i] << endl;\n    }\n    \n    // Calcular suma y promedio\n    int suma = 0;\n    for (int i = 0; i < TAM; i++) {\n        suma += calificaciones[i];\n    }\n    double promedio = static_cast<double>(suma) / TAM;\n    cout << \"\\nPromedio: \" << promedio << endl;\n    \n    // Encontrar máximo y mínimo\n    int maximo = calificaciones[0];\n    int minimo = calificaciones[0];\n    \n    for (int i = 1; i < TAM; i++) {\n        if (calificaciones[i] > maximo) {\n            maximo = calificaciones[i];\n        }\n        if (calificaciones[i] < minimo) {\n            minimo = calificaciones[i];\n        }\n    }\n    \n    cout << \"Calificación máxima: \" << maximo << endl;\n    cout << \"Calificación mínima: \" << minimo << endl;\n    \n    // Invertir arreglo\n    cout << \"\\nArreglo invertido:\" << endl;\n    for (int i = TAM - 1; i >= 0; i--) {\n        cout << calificaciones[i] << \" \";\n    }\n    cout << endl;\n    \n    // Copiar arreglo\n    int copia[TAM];\n    for (int i = 0; i < TAM; i++) {\n        copia[i] = calificaciones[i];\n    }\n    \n    return 0;\n}",
                "mindmap-array-operations.png",
                "interactive-array-operations",
                Arrays.asList(
                        new CodeExplanation(1, "for (int i = 0; i < TAM; i++)", "Recorrido estándar de arreglo"),
                        new CodeExplanation(2, "suma += arr[i]", "Acumulación de valores"),
                        new CodeExplanation(3, "Máximo/Mínimo", "Comparar cada elemento y actualizar"),
                        new CodeExplanation(4, "Invertir", "Recorrer de fin a inicio"),
                        new CodeExplanation(5, "Copiar", "Asignar elemento por elemento")
                )
        );
        content4_1_2.setLesson(lesson4_1_2);

        lesson4_1_2.setContent(content4_1_2);
        lessonService.save(lesson4_1_2);

        // Lección 4.1.3: Búsqueda y Ordenamiento Básico
        Lesson lesson4_1_3 = createLesson("Búsqueda y Ordenamiento Básico", "35 min", false, false);
        lesson4_1_3.setTopic(topic4_1);

        LessonContent content4_1_3 = createLessonContent(
                "https://example.com/videos/cpp-search-sort",
                "https://example.com/audio/cpp-search-sort",
                "Busqueda_Ordenamiento.pdf",
                "#include <iostream>\nusing namespace std;\n\n// Búsqueda lineal\nint busquedaLineal(int arr[], int tam, int valor) {\n    for (int i = 0; i < tam; i++) {\n        if (arr[i] == valor) {\n            return i;  // Retorna el índice\n        }\n    }\n    return -1;  // No encontrado\n}\n\n// Ordenamiento burbuja\nvoid ordenamientoBurbuja(int arr[], int tam) {\n    for (int i = 0; i < tam - 1; i++) {\n        for (int j = 0; j < tam - i - 1; j++) {\n            if (arr[j] > arr[j + 1]) {\n                // Intercambiar\n                int temp = arr[j];\n                arr[j] = arr[j + 1];\n                arr[j + 1] = temp;\n            }\n        }\n    }\n}\n\n// Ordenamiento por selección\nvoid ordenamientoSeleccion(int arr[], int tam) {\n    for (int i = 0; i < tam - 1; i++) {\n        int minIdx = i;\n        for (int j = i + 1; j < tam; j++) {\n            if (arr[j] < arr[minIdx]) {\n                minIdx = j;\n            }\n        }\n        // Intercambiar\n        int temp = arr[i];\n        arr[i] = arr[minIdx];\n        arr[minIdx] = temp;\n    }\n}\n\nvoid mostrarArreglo(int arr[], int tam) {\n    for (int i = 0; i < tam; i++) {\n        cout << arr[i] << \" \";\n    }\n    cout << endl;\n}\n\nint main() {\n    int numeros[] = {64, 34, 25, 12, 22, 11, 90};\n    int tam = sizeof(numeros) / sizeof(numeros[0]);\n    \n    cout << \"Arreglo original: \";\n    mostrarArreglo(numeros, tam);\n    \n    // Búsqueda lineal\n    int buscado = 25;\n    int posicion = busquedaLineal(numeros, tam, buscado);\n    if (posicion != -1) {\n        cout << \"\\nElemento \" << buscado << \" encontrado en posición \" << posicion << endl;\n    } else {\n        cout << \"\\nElemento no encontrado\" << endl;\n    }\n    \n    // Ordenamiento burbuja\n    int arr1[] = {64, 34, 25, 12, 22, 11, 90};\n    cout << \"\\nOrdenamiento Burbuja:\" << endl;\n    cout << \"Antes: \";\n    mostrarArreglo(arr1, tam);\n    ordenamientoBurbuja(arr1, tam);\n    cout << \"Después: \";\n    mostrarArreglo(arr1, tam);\n    \n    // Ordenamiento por selección\n    int arr2[] = {64, 34, 25, 12, 22, 11, 90};\n    cout << \"\\nOrdenamiento Selección:\" << endl;\n    cout << \"Antes: \";\n    mostrarArreglo(arr2, tam);\n    ordenamientoSeleccion(arr2, tam);\n    cout << \"Después: \";\n    mostrarArreglo(arr2, tam);\n    \n    return 0;\n}",
                "mindmap-search-sort.png",
                "interactive-algorithm-visualizer",
                Arrays.asList(
                        new CodeExplanation(1, "Búsqueda lineal", "Recorre elemento por elemento hasta encontrar"),
                        new CodeExplanation(2, "Complejidad O(n)", "Puede revisar todos los elementos"),
                        new CodeExplanation(3, "Burbuja", "Compara pares adyacentes e intercambia"),
                        new CodeExplanation(4, "Selección", "Encuentra el mínimo y lo coloca en posición"),
                        new CodeExplanation(5, "Intercambio", "Usa variable temporal para swap")
                )
        );
        content4_1_3.setLesson(lesson4_1_3);

        lesson4_1_3.setContent(content4_1_3);
        lessonService.save(lesson4_1_3);

        // Tema 4.2: Arreglos Multidimensionales
        Topic topic4_2 = createTopic("Arreglos Multidimensionales", false);
        topic4_2.setModule(module4);
        topicService.save(topic4_2);

        // Lección 4.2.1: Matrices (Arreglos 2D)
        Lesson lesson4_2_1 = createLesson("Matrices (Arreglos 2D)", "32 min", false, false);
        lesson4_2_1.setTopic(topic4_2);

        LessonContent content4_2_1 = createLessonContent(
                "https://example.com/videos/cpp-matrices",
                "https://example.com/audio/cpp-matrices",
                "Matrices_2D.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Declaración e inicialización de matriz 3x3\n    int matriz[3][3] = {\n        {1, 2, 3},\n        {4, 5, 6},\n        {7, 8, 9}\n    };\n    \n    // Acceso a elementos\n    cout << \"Elemento [0][0]: \" << matriz[0][0] << endl;\n    cout << \"Elemento [1][2]: \" << matriz[1][2] << endl;\n    \n    // Mostrar matriz completa\n    cout << \"\\nMatriz completa:\" << endl;\n    for (int i = 0; i < 3; i++) {\n        for (int j = 0; j < 3; j++) {\n            cout << matriz[i][j] << \"\\t\";\n        }\n        cout << endl;\n    }\n    \n    // Matriz de calificaciones\n    double calificaciones[3][4] = {\n        {8.5, 9.0, 7.5, 8.0},  // Estudiante 1\n        {7.0, 8.5, 9.0, 7.5},  // Estudiante 2\n        {9.5, 9.0, 9.5, 10.0}  // Estudiante 3\n    };\n    \n    // Calcular promedio por estudiante\n    cout << \"\\nPromedios por estudiante:\" << endl;\n    for (int i = 0; i < 3; i++) {\n        double suma = 0;\n        for (int j = 0; j < 4; j++) {\n            suma += calificaciones[i][j];\n        }\n        double promedio = suma / 4.0;\n        cout << \"Estudiante \" << (i+1) << \": \" << promedio << endl;\n    }\n    \n    // Suma de matrices\n    int A[2][2] = {{1, 2}, {3, 4}};\n    int B[2][2] = {{5, 6}, {7, 8}};\n    int C[2][2];\n    \n    for (int i = 0; i < 2; i++) {\n        for (int j = 0; j < 2; j++) {\n            C[i][j] = A[i][j] + B[i][j];\n        }\n    }\n    \n    cout << \"\\nSuma de matrices:\" << endl;\n    for (int i = 0; i < 2; i++) {\n        for (int j = 0; j < 2; j++) {\n            cout << C[i][j] << \" \";\n        }\n        cout << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-matrices.png",
                "interactive-matrix-operations",
                Arrays.asList(
                        new CodeExplanation(1, "int matriz[3][3]", "Matriz de 3 filas y 3 columnas"),
                        new CodeExplanation(2, "matriz[i][j]", "Acceso: [fila][columna]"),
                        new CodeExplanation(3, "Ciclos anidados", "Ciclo externo para filas, interno para columnas"),
                        new CodeExplanation(4, "Inicialización", "Lista de listas entre llaves"),
                        new CodeExplanation(5, "Operaciones", "Suma, resta elemento por elemento")
                )
        );
        content4_2_1.setLesson(lesson4_2_1);

        lesson4_2_1.setContent(content4_2_1);
        lessonService.save(lesson4_2_1);

        // Lección 4.2.2: Recorrido de Matrices
        Lesson lesson4_2_2 = createLesson("Recorrido de Matrices", "28 min", false, false);
        lesson4_2_2.setTopic(topic4_2);

        LessonContent content4_2_2 = createLessonContent(
                "https://example.com/videos/cpp-matrix-traversal",
                "https://example.com/audio/cpp-matrix-traversal",
                "Recorrido_Matrices.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    const int FILAS = 4;\n    const int COLS = 4;\n    int matriz[FILAS][COLS] = {\n        {1,  2,  3,  4},\n        {5,  6,  7,  8},\n        {9,  10, 11, 12},\n        {13, 14, 15, 16}\n    };\n    \n    // Recorrido por filas\n    cout << \"Recorrido por filas:\" << endl;\n    for (int i = 0; i < FILAS; i++) {\n        for (int j = 0; j < COLS; j++) {\n            cout << matriz[i][j] << \" \";\n        }\n        cout << endl;\n    }\n    \n    // Recorrido por columnas\n    cout << \"\\nRecorrido por columnas:\" << endl;\n    for (int j = 0; j < COLS; j++) {\n        for (int i = 0; i < FILAS; i++) {\n            cout << matriz[i][j] << \" \";\n        }\n        cout << endl;\n    }\n    \n    // Diagonal principal\n    cout << \"\\nDiagonal principal: \";\n    for (int i = 0; i < FILAS; i++) {\n        cout << matriz[i][i] << \" \";\n    }\n    cout << endl;\n    \n    // Diagonal secundaria\n    cout << \"Diagonal secundaria: \";\n    for (int i = 0; i < FILAS; i++) {\n        cout << matriz[i][COLS - 1 - i] << \" \";\n    }\n    cout << endl;\n    \n    // Suma de cada fila\n    cout << \"\\nSuma por filas:\" << endl;\n    for (int i = 0; i < FILAS; i++) {\n        int sumaFila = 0;\n        for (int j = 0; j < COLS; j++) {\n            sumaFila += matriz[i][j];\n        }\n        cout << \"Fila \" << i << \": \" << sumaFila << endl;\n    }\n    \n    // Suma de cada columna\n    cout << \"\\nSuma por columnas:\" << endl;\n    for (int j = 0; j < COLS; j++) {\n        int sumaCol = 0;\n        for (int i = 0; i < FILAS; i++) {\n            sumaCol += matriz[i][j];\n        }\n        cout << \"Columna \" << j << \": \" << sumaCol << endl;\n    }\n    \n    // Transpuesta\n    int transpuesta[COLS][FILAS];\n    for (int i = 0; i < FILAS; i++) {\n        for (int j = 0; j < COLS; j++) {\n            transpuesta[j][i] = matriz[i][j];\n        }\n    }\n    \n    cout << \"\\nMatriz transpuesta:\" << endl;\n    for (int i = 0; i < COLS; i++) {\n        for (int j = 0; j < FILAS; j++) {\n            cout << transpuesta[i][j] << \"\\t\";\n        }\n        cout << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-matrix-traversal.png",
                "interactive-traversal-visualizer",
                Arrays.asList(
                        new CodeExplanation(1, "Por filas", "Ciclo externo: filas, interno: columnas"),
                        new CodeExplanation(2, "Por columnas", "Ciclo externo: columnas, interno: filas"),
                        new CodeExplanation(3, "Diagonal principal", "Elementos donde i == j"),
                        new CodeExplanation(4, "Diagonal secundaria", "Elementos donde i + j == n-1"),
                        new CodeExplanation(5, "Transpuesta", "Intercambiar filas por columnas")
                )
        );
        content4_2_2.setLesson(lesson4_2_2);

        lesson4_2_2.setContent(content4_2_2);
        lessonService.save(lesson4_2_2);

        // Tema 4.3: Introducción a Vectores STL
        Topic topic4_3 = createTopic("Introducción a Vectores STL", false);
        topic4_3.setModule(module4);
        topicService.save(topic4_3);

        // Lección 4.3.1: Vectores Dinámicos
        Lesson lesson4_3_1 = createLesson("Vectores Dinámicos", "30 min", false, false);
        lesson4_3_1.setTopic(topic4_3);

        LessonContent content4_3_1 = createLessonContent(
                "https://example.com/videos/cpp-vectors",
                "https://example.com/audio/cpp-vectors",
                "Vectores_STL.pdf",
                "#include <iostream>\n#include <vector>\nusing namespace std;\n\nint main() {\n    // Declaración de vector vacío\n    vector<int> numeros;\n    \n    // Agregar elementos\n    numeros.push_back(10);\n    numeros.push_back(20);\n    numeros.push_back(30);\n    numeros.push_back(40);\n    \n    cout << \"Tamaño: \" << numeros.size() << endl;\n    \n    // Vector con inicialización\n    vector<int> valores = {5, 10, 15, 20, 25};\n    \n    // Vector con tamaño inicial\n    vector<double> precios(5);  // 5 elementos con valor 0\n    vector<int> edades(3, 18);  // 3 elementos con valor 18\n    \n    // Acceso a elementos\n    cout << \"Primer elemento: \" << numeros[0] << endl;\n    cout << \"Con at(): \" << numeros.at(1) << endl;  // Más seguro\n    \n    // Recorrer con índices\n    cout << \"\\nRecorrido con índices:\" << endl;\n    for (int i = 0; i < valores.size(); i++) {\n        cout << valores[i] << \" \";\n    }\n    cout << endl;\n    \n    // Recorrer con range-based for (C++11)\n    cout << \"\\nRecorrido con range-based for:\" << endl;\n    for (int num : valores) {\n        cout << num << \" \";\n    }\n    cout << endl;\n    \n    // Modificar elementos\n    valores[2] = 100;\n    cout << \"\\nDespués de modificar: \";\n    for (int num : valores) {\n        cout << num << \" \";\n    }\n    cout << endl;\n    \n    // Eliminar último elemento\n    valores.pop_back();\n    cout << \"\\nDespués de pop_back: \";\n    for (int num : valores) {\n        cout << num << \" \";\n    }\n    cout << endl;\n    \n    // Verificar si está vacío\n    if (!valores.empty()) {\n        cout << \"El vector NO está vacío\" << endl;\n    }\n    \n    // Limpiar todos los elementos\n    valores.clear();\n    cout << \"Tamaño después de clear: \" << valores.size() << endl;\n    \n    // Vector de strings\n    vector<string> nombres;\n    nombres.push_back(\"Ana\");\n    nombres.push_back(\"Carlos\");\n    nombres.push_back(\"María\");\n    \n    cout << \"\\nNombres:\" << endl;\n    for (const string& nombre : nombres) {\n        cout << \"- \" << nombre << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-vectors.png",
                "interactive-vector-operations",
                Arrays.asList(
                        new CodeExplanation(1, "#include <vector>", "Incluir biblioteca de vectores"),
                        new CodeExplanation(2, "vector<int> v", "Declara vector de enteros"),
                        new CodeExplanation(3, "push_back()", "Agrega elemento al final"),
                        new CodeExplanation(4, "size()", "Retorna número de elementos"),
                        new CodeExplanation(5, "Dinámico", "Crece automáticamente según necesidad"),
                        new CodeExplanation(6, "at() vs []", "at() verifica límites, [] es más rápido"),
                        new CodeExplanation(7, "pop_back()", "Elimina último elemento")
                )
        );
        content4_3_1.setLesson(lesson4_3_1);

        lesson4_3_1.setContent(content4_3_1);
        lessonService.save(lesson4_3_1);

        // ========== MÓDULO 5: CADENAS DE TEXTO ==========
        ModuleModel module5 = createModule(
                "Cadenas de Texto",
                "Manejo de strings, operaciones de texto y procesamiento de cadenas",
                "10 horas", 250, 0, false);
        module5.setCourse(cppCourse);
        moduleService.save(module5);

        // Tema 5.1: Manejo de Strings
        Topic topic5_1 = createTopic("Manejo de Strings", false);
        topic5_1.setModule(module5);
        topicService.save(topic5_1);

        // Lección 5.1.1: Arreglos de Caracteres vs String
        Lesson lesson5_1_1 = createLesson("Arreglos de Caracteres vs String", "25 min", false, false);
        lesson5_1_1.setTopic(topic5_1);

        LessonContent content5_1_1 = createLessonContent(
                "https://example.com/videos/cpp-strings-intro",
                "https://example.com/audio/cpp-strings-intro",
                "Strings_Introduccion.pdf",
                "#include <iostream>\n#include <string>\n#include <cstring>\nusing namespace std;\n\nint main() {\n    // Arreglo de caracteres estilo C\n    char nombre1[20] = \"Carlos\";\n    char apellido[20];\n    strcpy(apellido, \"García\");\n    \n    cout << \"Nombre (char[]): \" << nombre1 << endl;\n    cout << \"Apellido (char[]): \" << apellido << endl;\n    \n    // Longitud con strlen\n    cout << \"Longitud de nombre: \" << strlen(nombre1) << endl;\n    \n    // String de C++ (más fácil y seguro)\n    string nombre2 = \"María\";\n    string ciudad = \"Bogotá\";\n    \n    cout << \"\\nNombre (string): \" << nombre2 << endl;\n    cout << \"Ciudad: \" << ciudad << endl;\n    \n    // Longitud con length() o size()\n    cout << \"Longitud de nombre: \" << nombre2.length() << endl;\n    cout << \"Tamaño de ciudad: \" << ciudad.size() << endl;\n    \n    // Concatenación\n    // Con char[]: complicado y peligroso\n    char completo1[50];\n    strcpy(completo1, nombre1);\n    strcat(completo1, \" \");\n    strcat(completo1, apellido);\n    cout << \"\\nNombre completo (char[]): \" << completo1 << endl;\n    \n    // Con string: simple y seguro\n    string completo2 = nombre2 + \" \" + \"López\";\n    cout << \"Nombre completo (string): \" << completo2 << endl;\n    \n    // Comparación\n    // Con char[]\n    if (strcmp(nombre1, \"Carlos\") == 0) {\n        cout << \"\\nLos nombres son iguales (char[])\" << endl;\n    }\n    \n    // Con string\n    if (nombre2 == \"María\") {\n        cout << \"Los nombres son iguales (string)\" << endl;\n    }\n    \n    // Input\n    string respuesta;\n    cout << \"\\n¿Cuál es tu nombre? \";\n    getline(cin, respuesta);  // Lee línea completa con espacios\n    cout << \"Hola, \" << respuesta << \"!\" << endl;\n    \n    return 0;\n}",
                "mindmap-strings.png",
                "interactive-string-comparison",
                Arrays.asList(
                        new CodeExplanation(1, "char[]", "Arreglo de caracteres terminado en '\\0'"),
                        new CodeExplanation(2, "string", "Clase de C++ más fácil y segura"),
                        new CodeExplanation(3, "strcpy, strcat", "Funciones de C para char[]"),
                        new CodeExplanation(4, "+", "Operador de concatenación para string"),
                        new CodeExplanation(5, "getline()", "Lee línea completa incluyendo espacios")
                )
        );
        content5_1_1.setLesson(lesson5_1_1);

        lesson5_1_1.setContent(content5_1_1);
        lessonService.save(lesson5_1_1);

        // Lección 5.1.2: Operaciones con Strings
        Lesson lesson5_1_2 = createLesson("Operaciones con Strings", "30 min", false, false);
        lesson5_1_2.setTopic(topic5_1);

        LessonContent content5_1_2 = createLessonContent(
                "https://example.com/videos/cpp-string-operations",
                "https://example.com/audio/cpp-string-operations",
                "Operaciones_Strings.pdf",
                "#include <iostream>\n#include <string>\n#include <algorithm>\nusing namespace std;\n\nint main() {\n    string texto = \"Hola Mundo desde C++\";\n    \n    // Longitud\n    cout << \"Longitud: \" << texto.length() << endl;\n    \n    // Acceso a caracteres\n    cout << \"Primer carácter: \" << texto[0] << endl;\n    cout << \"Último carácter: \" << texto[texto.length()-1] << endl;\n    \n    // Subcadena\n    string sub = texto.substr(5, 5);  // Desde pos 5, 5 caracteres\n    cout << \"Subcadena: \" << sub << endl;\n    \n    // Buscar\n    size_t posicion = texto.find(\"Mundo\");\n    if (posicion != string::npos) {\n        cout << \"'Mundo' encontrado en posición: \" << posicion << endl;\n    }\n    \n    // Reemplazar\n    string reemplazo = texto;\n    size_t pos = reemplazo.find(\"Mundo\");\n    if (pos != string::npos) {\n        reemplazo.replace(pos, 5, \"Universo\");\n    }\n    cout << \"Reemplazado: \" << reemplazo << endl;\n    \n    // Insertar\n    string insercion = \"Hola Mundo\";\n    insercion.insert(5, \"Bello \");\n    cout << \"Insertado: \" << insercion << endl;\n    \n    // Eliminar\n    string borrado = \"Hola Mundo Cruel\";\n    borrado.erase(11, 6);  // Borra \" Cruel\"\n    cout << \"Borrado: \" << borrado << endl;\n    \n    // Concatenar\n    string parte1 = \"Programación \";\n    string parte2 = \"en C++\";\n    string completo = parte1 + parte2;\n    cout << \"Concatenado: \" << completo << endl;\n    \n    // Append\n    string mensaje = \"Hola\";\n    mensaje.append(\" \").append(\"Mundo\");\n    cout << \"Append: \" << mensaje << endl;\n    \n    // Comparar\n    string str1 = \"abc\";\n    string str2 = \"def\";\n    if (str1 < str2) {\n        cout << str1 << \" es menor que \" << str2 << endl;\n    }\n    \n    // Vacío\n    string vacio = \"\";\n    if (vacio.empty()) {\n        cout << \"El string está vacío\" << endl;\n    }\n    \n    // Limpiar\n    texto.clear();\n    cout << \"Longitud después de clear: \" << texto.length() << endl;\n    \n    return 0;\n}",
                "mindmap-string-methods.png",
                "interactive-string-methods",
                Arrays.asList(
                        new CodeExplanation(1, "length() / size()", "Retorna número de caracteres"),
                        new CodeExplanation(2, "substr(pos, len)", "Extrae subcadena"),
                        new CodeExplanation(3, "find(str)", "Busca subcadena, retorna posición"),
                        new CodeExplanation(4, "replace(pos, len, str)", "Reemplaza porción de texto"),
                        new CodeExplanation(5, "insert(pos, str)", "Inserta texto en posición"),
                        new CodeExplanation(6, "erase(pos, len)", "Elimina caracteres"),
                        new CodeExplanation(7, "append(str)", "Agrega al final")
                )
        );
        content5_1_2.setLesson(lesson5_1_2);

        lesson5_1_2.setContent(content5_1_2);
        lessonService.save(lesson5_1_2);

        // Lección 5.1.3: Procesamiento de Texto
        Lesson lesson5_1_3 = createLesson("Procesamiento de Texto", "28 min", false, false);
        lesson5_1_3.setTopic(topic5_1);

        LessonContent content5_1_3 = createLessonContent(
                "https://example.com/videos/cpp-text-processing",
                "https://example.com/audio/cpp-text-processing",
                "Procesamiento_Texto.pdf",
                "#include <iostream>\n#include <string>\n#include <algorithm>\n#include <cctype>\nusing namespace std;\n\n// Contar vocales\nint contarVocales(string texto) {\n    int contador = 0;\n    for (char c : texto) {\n        c = tolower(c);\n        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {\n            contador++;\n        }\n    }\n    return contador;\n}\n\n// Contar palabras\nint contarPalabras(string texto) {\n    int contador = 0;\n    bool enPalabra = false;\n    for (char c : texto) {\n        if (isspace(c)) {\n            enPalabra = false;\n        } else if (!enPalabra) {\n            contador++;\n            enPalabra = true;\n        }\n    }\n    return contador;\n}\n\n// Invertir string\nstring invertir(string texto) {\n    string invertido = texto;\n    reverse(invertido.begin(), invertido.end());\n    return invertido;\n}\n\n// Convertir a mayúsculas\nstring aMayusculas(string texto) {\n    string resultado = texto;\n    transform(resultado.begin(), resultado.end(), resultado.begin(), ::toupper);\n    return resultado;\n}\n\n// Convertir a minúsculas\nstring aMinusculas(string texto) {\n    string resultado = texto;\n    transform(resultado.begin(), resultado.end(), resultado.begin(), ::tolower);\n    return resultado;\n}\n\n// Verificar si es palíndromo\nbool esPalindromo(string texto) {\n    string limpio;\n    for (char c : texto) {\n        if (isalnum(c)) {\n            limpio += tolower(c);\n        }\n    }\n    string invertido = limpio;\n    reverse(invertido.begin(), invertido.end());\n    return limpio == invertido;\n}\n\nint main() {\n    string texto = \"Hola Mundo de la Programacion\";\n    \n    // Contar vocales\n    cout << \"Vocales: \" << contarVocales(texto) << endl;\n    \n    // Contar palabras\n    cout << \"Palabras: \" << contarPalabras(texto) << endl;\n    \n    // Invertir\n    cout << \"Invertido: \" << invertir(texto) << endl;\n    \n    // Mayúsculas y minúsculas\n    cout << \"Mayúsculas: \" << aMayusculas(texto) << endl;\n    cout << \"Minúsculas: \" << aMinusculas(texto) << endl;\n    \n    // Palíndromo\n    string palindromo = \"Anita lava la tina\";\n    if (esPalindromo(palindromo)) {\n        cout << \"'\" << palindromo << \"' es palíndromo\" << endl;\n    }\n    \n    // Validar email simple\n    string email = \"usuario@ejemplo.com\";\n    if (email.find('@') != string::npos && email.find('.') != string::npos) {\n        cout << \"Email válido\" << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-text-processing.png",
                "interactive-text-processor",
                Arrays.asList(
                        new CodeExplanation(1, "tolower() / toupper()", "Convierte caracteres a minúscula/mayúscula"),
                        new CodeExplanation(2, "isspace()", "Verifica si es espacio en blanco"),
                        new CodeExplanation(3, "reverse()", "Invierte el contenido del string"),
                        new CodeExplanation(4, "transform()", "Aplica función a cada carácter"),
                        new CodeExplanation(5, "isalnum()", "Verifica si es alfanumérico")
                )
        );
        content5_1_3.setLesson(lesson5_1_3);

        lesson5_1_3.setContent(content5_1_3);
        lessonService.save(lesson5_1_3);

        // ========== MÓDULO 6: PUNTEROS Y MEMORIA DINÁMICA ==========
        ModuleModel module6 = createModule(
                "Punteros y Memoria Dinámica",
                "Comprende punteros, referencias y gestión de memoria dinámica con new y delete",
                "12 horas", 400, 0, false);
        module6.setCourse(cppCourse);
        moduleService.save(module6);

        // Tema 6.1: Fundamentos de Punteros
        Topic topic6_1 = createTopic("Fundamentos de Punteros", false);
        topic6_1.setModule(module6);
        topicService.save(topic6_1);

        // Lección 6.1.1: Introducción a Punteros
        Lesson lesson6_1_1 = createLesson("Introducción a Punteros", "35 min", false, false);
        lesson6_1_1.setTopic(topic6_1);

        LessonContent content6_1_1 = createLessonContent(
                "https://example.com/videos/cpp-pointers-intro",
                "https://example.com/audio/cpp-pointers-intro",
                "Introduccion_Punteros.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Variable normal\n    int numero = 42;\n    cout << \"Valor de numero: \" << numero << endl;\n    cout << \"Dirección de numero: \" << &numero << endl;\n    \n    // Declaración de puntero\n    int* ptr;  // Puntero a entero\n    ptr = &numero;  // Asigna dirección de numero\n    \n    cout << \"\\nPuntero ptr:\" << endl;\n    cout << \"Dirección almacenada en ptr: \" << ptr << endl;\n    cout << \"Valor al que apunta (*ptr): \" << *ptr << endl;\n    \n    // Modificar a través del puntero\n    *ptr = 100;\n    cout << \"\\nDespués de *ptr = 100:\" << endl;\n    cout << \"numero: \" << numero << endl;\n    cout << \"*ptr: \" << *ptr << endl;\n    \n    // Operadores importantes\n    // & = operador de dirección (address-of)\n    // * = operador de indirección (dereference)\n    \n    // Ejemplo con diferentes tipos\n    double pi = 3.14159;\n    double* ptrDouble = &pi;\n    cout << \"\\nPuntero a double:\" << endl;\n    cout << \"Valor: \" << *ptrDouble << endl;\n    \n    char letra = 'A';\n    char* ptrChar = &letra;\n    cout << \"\\nPuntero a char:\" << endl;\n    cout << \"Valor: \" << *ptrChar << endl;\n    \n    // Puntero nulo\n    int* ptrNulo = nullptr;  // C++11\n    if (ptrNulo == nullptr) {\n        cout << \"\\nEl puntero es nulo\" << endl;\n    }\n    \n    // Tamaño de punteros\n    cout << \"\\nTamaño de punteros:\" << endl;\n    cout << \"sizeof(int*): \" << sizeof(int*) << \" bytes\" << endl;\n    cout << \"sizeof(double*): \" << sizeof(double*) << \" bytes\" << endl;\n    \n    return 0;\n}",
                "mindmap-pointers.png",
                "interactive-pointer-memory",
                Arrays.asList(
                        new CodeExplanation(1, "int* ptr", "Declara puntero a entero"),
                        new CodeExplanation(2, "&variable", "Operador de dirección - obtiene la dirección"),
                        new CodeExplanation(3, "*ptr", "Operador de indirección - accede al valor"),
                        new CodeExplanation(4, "nullptr", "Puntero nulo (C++11)"),
                        new CodeExplanation(5, "Dirección de memoria", "Ubicación en memoria RAM")
                )
        );
        content6_1_1.setLesson(lesson6_1_1);

        lesson6_1_1.setContent(content6_1_1);
        lessonService.save(lesson6_1_1);

        // Lección 6.1.2: Punteros y Arreglos
        Lesson lesson6_1_2 = createLesson("Punteros y Arreglos", "30 min", false, false);
        lesson6_1_2.setTopic(topic6_1);

        LessonContent content6_1_2 = createLessonContent(
                "https://example.com/videos/cpp-pointers-arrays",
                "https://example.com/audio/cpp-pointers-arrays",
                "Punteros_Arreglos.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    int numeros[] = {10, 20, 30, 40, 50};\n    int* ptr = numeros;  // El nombre del arreglo es un puntero al primer elemento\n    \n    // Equivalencias\n    cout << \"numeros[0]: \" << numeros[0] << endl;\n    cout << \"*numeros: \" << *numeros << endl;\n    cout << \"*ptr: \" << *ptr << endl;\n    \n    // Acceso con notación de arreglo\n    cout << \"\\nAcceso con []:\" << endl;\n    for (int i = 0; i < 5; i++) {\n        cout << numeros[i] << \" \";\n    }\n    cout << endl;\n    \n    // Acceso con aritmética de punteros\n    cout << \"\\nAcceso con punteros:\" << endl;\n    for (int i = 0; i < 5; i++) {\n        cout << *(ptr + i) << \" \";\n    }\n    cout << endl;\n    \n    // Incremento de punteros\n    cout << \"\\nRecorrido con incremento:\" << endl;\n    int* p = numeros;\n    for (int i = 0; i < 5; i++) {\n        cout << *p << \" \";\n        p++;  // Avanza al siguiente elemento\n    }\n    cout << endl;\n    \n    // Diferencia de punteros\n    int* inicio = numeros;\n    int* fin = &numeros[4];\n    cout << \"\\nDiferencia de punteros: \" << (fin - inicio) << endl;\n    \n    // Punteros y strings (arreglos de char)\n    char mensaje[] = \"Hola\";\n    char* ptrChar = mensaje;\n    cout << \"\\nString con puntero: \" << ptrChar << endl;\n    \n    // Modificar a través de punteros\n    *(ptr + 2) = 300;  // Modifica numeros[2]\n    cout << \"\\nDespués de modificar:\" << endl;\n    for (int i = 0; i < 5; i++) {\n        cout << numeros[i] << \" \";\n    }\n    cout << endl;\n    \n    return 0;\n}",
                "mindmap-pointers-arrays.png",
                "interactive-pointer-arithmetic",
                Arrays.asList(
                        new CodeExplanation(1, "int* ptr = arr", "Nombre del arreglo es puntero al primer elemento"),
                        new CodeExplanation(2, "arr[i] == *(arr + i)", "Equivalencia entre notaciones"),
                        new CodeExplanation(3, "ptr++", "Incrementa puntero al siguiente elemento"),
                        new CodeExplanation(4, "ptr + i", "Aritmética de punteros"),
                        new CodeExplanation(5, "fin - inicio", "Diferencia de punteros da número de elementos")
                )
        );
        content6_1_2.setLesson(lesson6_1_2);

        lesson6_1_2.setContent(content6_1_2);
        lessonService.save(lesson6_1_2);

        // Tema 6.2: Memoria Dinámica
        Topic topic6_2 = createTopic("Memoria Dinámica", false);
        topic6_2.setModule(module6);
        topicService.save(topic6_2);

        // Lección 6.2.1: Operadores new y delete
        Lesson lesson6_2_1 = createLesson("Operadores new y delete", "32 min", false, false);
        lesson6_2_1.setTopic(topic6_2);

        LessonContent content6_2_1 = createLessonContent(
                "https://example.com/videos/cpp-dynamic-memory",
                "https://example.com/audio/cpp-dynamic-memory",
                "Memoria_Dinamica.pdf",
                "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Asignación dinámica de una variable\n    int* ptr = new int;\n    *ptr = 42;\n    cout << \"Valor dinámico: \" << *ptr << endl;\n    delete ptr;  // Liberar memoria\n    ptr = nullptr;  // Buena práctica\n    \n    // Asignación con inicialización\n    double* ptrDouble = new double(3.14159);\n    cout << \"Double dinámico: \" << *ptrDouble << endl;\n    delete ptrDouble;\n    ptrDouble = nullptr;\n    \n    // Arreglo dinámico\n    int tamanio;\n    cout << \"\\n¿Cuántos números desea ingresar? \";\n    cin >> tamanio;\n    \n    int* numeros = new int[tamanio];\n    \n    cout << \"Ingrese \" << tamanio << \" números:\" << endl;\n    for (int i = 0; i < tamanio; i++) {\n        cout << \"Número \" << (i+1) << \": \";\n        cin >> numeros[i];\n    }\n    \n    cout << \"\\nNúmeros ingresados:\" << endl;\n    for (int i = 0; i < tamanio; i++) {\n        cout << numeros[i] << \" \";\n    }\n    cout << endl;\n    \n    // Liberar arreglo dinámico\n    delete[] numeros;\n    numeros = nullptr;\n    \n    // Matriz dinámica\n    int filas = 3, cols = 4;\n    int** matriz = new int*[filas];\n    for (int i = 0; i < filas; i++) {\n        matriz[i] = new int[cols];\n    }\n    \n    // Llenar matriz\n    int valor = 1;\n    for (int i = 0; i < filas; i++) {\n        for (int j = 0; j < cols; j++) {\n            matriz[i][j] = valor++;\n        }\n    }\n    \n    // Mostrar matriz\n    cout << \"\\nMatriz dinámica:\" << endl;\n    for (int i = 0; i < filas; i++) {\n        for (int j = 0; j < cols; j++) {\n            cout << matriz[i][j] << \"\\t\";\n        }\n        cout << endl;\n    }\n    \n    // Liberar matriz dinámica\n    for (int i = 0; i < filas; i++) {\n        delete[] matriz[i];\n    }\n    delete[] matriz;\n    matriz = nullptr;\n    \n    cout << \"\\nMemoria liberada correctamente\" << endl;\n    \n    return 0;\n}",
                "mindmap-dynamic-memory.png",
                "interactive-heap-stack",
                Arrays.asList(
                        new CodeExplanation(1, "new tipo", "Asigna memoria en el heap"),
                        new CodeExplanation(2, "delete ptr", "Libera memoria de una variable"),
                        new CodeExplanation(3, "new tipo[tam]", "Asigna arreglo dinámico"),
                        new CodeExplanation(4, "delete[] ptr", "Libera arreglo dinámico"),
                        new CodeExplanation(5, "Memory leak", "Olvidar delete causa fugas de memoria"),
                        new CodeExplanation(6, "ptr = nullptr", "Buena práctica después de delete")
                )
        );
        content6_2_1.setLesson(lesson6_2_1);

        lesson6_2_1.setContent(content6_2_1);
        lessonService.save(lesson6_2_1);

        // ========== MÓDULO 7: ESTRUCTURAS Y TIPOS PERSONALIZADOS ==========
        ModuleModel module7 = createModule(
                "Estructuras y Tipos de Datos Personalizados",
                "Crea tipos de datos personalizados con struct y una introducción a clases",
                "10 horas", 300, 0, false);
        module7.setCourse(cppCourse);
        moduleService.save(module7);

        // Tema 7.1: Estructuras (Struct)
        Topic topic7_1 = createTopic("Estructuras (Struct)", false);
        topic7_1.setModule(module7);
        topicService.save(topic7_1);

        // Lección 7.1.1: Definición y Uso de Estructuras
        Lesson lesson7_1_1 = createLesson("Definición y Uso de Estructuras", "28 min", false, false);
        lesson7_1_1.setTopic(topic7_1);

        LessonContent content7_1_1 = createLessonContent(
                "https://example.com/videos/cpp-structs",
                "https://example.com/audio/cpp-structs",
                "Estructuras_Intro.pdf",
                "#include <iostream>\n#include <string>\nusing namespace std;\n\n// Definición de estructura Estudiante\nstruct Estudiante {\n    string nombre;\n    int edad;\n    double promedio;\n    string carrera;\n};\n\n// Estructura Punto2D\nstruct Punto2D {\n    double x;\n    double y;\n};\n\n// Estructura Fecha\nstruct Fecha {\n    int dia;\n    int mes;\n    int anio;\n};\n\nvoid mostrarEstudiante(Estudiante est) {\n    cout << \"Nombre: \" << est.nombre << endl;\n    cout << \"Edad: \" << est.edad << endl;\n    cout << \"Promedio: \" << est.promedio << endl;\n    cout << \"Carrera: \" << est.carrera << endl;\n}\n\nint main() {\n    // Declaración e inicialización\n    Estudiante est1;\n    est1.nombre = \"Carlos\";\n    est1.edad = 20;\n    est1.promedio = 8.5;\n    est1.carrera = \"Ingeniería\";\n    \n    cout << \"Estudiante 1:\" << endl;\n    mostrarEstudiante(est1);\n    \n    // Inicialización en línea\n    Estudiante est2 = {\"María\", 22, 9.2, \"Medicina\"};\n    cout << \"\\nEstudiante 2:\" << endl;\n    mostrarEstudiante(est2);\n    \n    // Estructura Punto\n    Punto2D punto1 = {3.5, 7.2};\n    Punto2D punto2 = {1.0, 4.8};\n    \n    cout << \"\\nPunto 1: (\" << punto1.x << \", \" << punto1.y << \")\" << endl;\n    cout << \"Punto 2: (\" << punto2.x << \", \" << punto2.y << \")\" << endl;\n    \n    // Estructura Fecha\n    Fecha hoy = {29, 10, 2025};\n    cout << \"\\nFecha: \" << hoy.dia << \"/\" << hoy.mes << \"/\" << hoy.anio << endl;\n    \n    // Copiar estructuras\n    Estudiante est3 = est1;  // Copia todos los miembros\n    est3.nombre = \"Ana\";\n    cout << \"\\nEstudiante 3 (copia modificada):\" << endl;\n    mostrarEstudiante(est3);\n    \n    return 0;\n}",
                "mindmap-structs.png",
                "interactive-struct-builder",
                Arrays.asList(
                        new CodeExplanation(1, "struct Nombre { ... };", "Define tipo de dato personalizado"),
                        new CodeExplanation(2, "objeto.miembro", "Acceso a miembros con operador punto"),
                        new CodeExplanation(3, "Inicialización", "Puede inicializarse con lista entre llaves"),
                        new CodeExplanation(4, "Agrupación", "Agrupa datos relacionados en una unidad"),
                        new CodeExplanation(5, "Copia", "Asignación copia todos los miembros")
                )
        );
        content7_1_1.setLesson(lesson7_1_1);

        lesson7_1_1.setContent(content7_1_1);
        lessonService.save(lesson7_1_1);

        // Lección 7.1.2: Arreglos de Estructuras
        Lesson lesson7_1_2 = createLesson("Arreglos de Estructuras", "26 min", false, false);
        lesson7_1_2.setTopic(topic7_1);

        LessonContent content7_1_2 = createLessonContent(
                "https://example.com/videos/cpp-struct-arrays",
                "https://example.com/audio/cpp-struct-arrays",
                "Arrays_Estructuras.pdf",
                "#include <iostream>\n#include <string>\n#include <vector>\nusing namespace std;\n\nstruct Libro {\n    string titulo;\n    string autor;\n    int anio;\n    double precio;\n};\n\nvoid mostrarLibro(const Libro& libro) {\n    cout << \"Título: \" << libro.titulo << endl;\n    cout << \"Autor: \" << libro.autor << endl;\n    cout << \"Año: \" << libro.anio << endl;\n    cout << \"Precio: $\" << libro.precio << endl;\n    cout << \"-------------------\" << endl;\n}\n\nint main() {\n    // Arreglo de estructuras\n    Libro biblioteca[3] = {\n        {\"El Quijote\", \"Cervantes\", 1605, 29.99},\n        {\"Cien Años de Soledad\", \"García Márquez\", 1967, 34.99},\n        {\"1984\", \"George Orwell\", 1949, 24.99}\n    };\n    \n    cout << \"BIBLIOTECA - Arreglo estático:\" << endl;\n    for (int i = 0; i < 3; i++) {\n        cout << \"\\nLibro \" << (i+1) << \":\" << endl;\n        mostrarLibro(biblioteca[i]);\n    }\n    \n    // Vector de estructuras (dinámico)\n    vector<Libro> coleccion;\n    \n    coleccion.push_back({\"Harry Potter\", \"J.K. Rowling\", 1997, 39.99});\n    coleccion.push_back({\"El Hobbit\", \"J.R.R. Tolkien\", 1937, 32.99});\n    \n    cout << \"\\nCOLECCIÓN - Vector dinámico:\" << endl;\n    for (size_t i = 0; i < coleccion.size(); i++) {\n        cout << \"\\nLibro \" << (i+1) << \":\" << endl;\n        mostrarLibro(coleccion[i]);\n    }\n    \n    // Buscar por criterio\n    string autorBuscado = \"Cervantes\";\n    cout << \"\\nBuscando libros de \" << autorBuscado << \":\" << endl;\n    for (const auto& libro : biblioteca) {\n        if (libro.autor == autorBuscado) {\n            mostrarLibro(libro);\n        }\n    }\n    \n    // Calcular precio total\n    double total = 0;\n    for (const auto& libro : biblioteca) {\n        total += libro.precio;\n    }\n    cout << \"\\nPrecio total de la biblioteca: $\" << total << endl;\n    \n    // Libro más antiguo\n    Libro* masAntiguo = &biblioteca[0];\n    for (int i = 1; i < 3; i++) {\n        if (biblioteca[i].anio < masAntiguo->anio) {\n            masAntiguo = &biblioteca[i];\n        }\n    }\n    cout << \"\\nLibro más antiguo:\" << endl;\n    mostrarLibro(*masAntiguo);\n    \n    return 0;\n}",
                "mindmap-struct-arrays.png",
                "interactive-struct-database",
                Arrays.asList(
                        new CodeExplanation(1, "Struct arr[n]", "Arreglo de estructuras"),
                        new CodeExplanation(2, "vector<Struct>", "Vector dinámico de estructuras"),
                        new CodeExplanation(3, "arr[i].miembro", "Acceso a miembro de elemento del arreglo"),
                        new CodeExplanation(4, "Búsqueda", "Recorrer y comparar miembros"),
                        new CodeExplanation(5, "Agregación", "Procesar datos de múltiples estructuras")
                )
        );
        content7_1_2.setLesson(lesson7_1_2);

        lesson7_1_2.setContent(content7_1_2);
        lessonService.save(lesson7_1_2);

        // Tema 7.2: Introducción a Clases
        Topic topic7_2 = createTopic("Introducción a Clases (Opcional)", false);
        topic7_2.setModule(module7);
        topicService.save(topic7_2);

        // Lección 7.2.1: Diferencia entre Struct y Class
        Lesson lesson7_2_1 = createLesson("Diferencia entre Struct y Class", "25 min", false, false);
        lesson7_2_1.setTopic(topic7_2);

        LessonContent content7_2_1 = createLessonContent(
                "https://example.com/videos/cpp-struct-vs-class",
                "https://example.com/audio/cpp-struct-vs-class",
                "Struct_vs_Class.pdf",
                "#include <iostream>\n#include <string>\nusing namespace std;\n\n// Struct - miembros públicos por defecto\nstruct PersonaStruct {\n    string nombre;\n    int edad;\n    \n    void saludar() {\n        cout << \"Hola, soy \" << nombre << endl;\n    }\n};\n\n// Class - miembros privados por defecto\nclass PersonaClass {\nprivate:\n    string nombre;\n    int edad;\n    \npublic:\n    // Constructor\n    PersonaClass(string n, int e) {\n        nombre = n;\n        edad = e;\n    }\n    \n    // Métodos públicos (getters)\n    string getNombre() {\n        return nombre;\n    }\n    \n    int getEdad() {\n        return edad;\n    }\n    \n    // Métodos públicos (setters)\n    void setNombre(string n) {\n        nombre = n;\n    }\n    \n    void setEdad(int e) {\n        if (e > 0 && e < 150) {\n            edad = e;\n        }\n    }\n    \n    void saludar() {\n        cout << \"Hola, soy \" << nombre << \" y tengo \" << edad << \" años\" << endl;\n    }\n};\n\nint main() {\n    // Usando struct\n    PersonaStruct p1;\n    p1.nombre = \"Carlos\";  // Acceso directo\n    p1.edad = 25;\n    p1.saludar();\n    \n    // Usando class\n    PersonaClass p2(\"María\", 30);  // Constructor\n    p2.saludar();\n    \n    // Con class, no se puede acceder directamente a miembros privados\n    // p2.nombre = \"Ana\";  // ERROR: nombre es privado\n    \n    // Usar métodos públicos\n    p2.setNombre(\"Ana\");\n    p2.setEdad(28);\n    cout << \"Nuevo nombre: \" << p2.getNombre() << endl;\n    p2.saludar();\n    \n    cout << \"\\nDiferencias clave:\" << endl;\n    cout << \"1. Struct: miembros públicos por defecto\" << endl;\n    cout << \"2. Class: miembros privados por defecto\" << endl;\n    cout << \"3. Class: encapsulación y control de acceso\" << endl;\n    cout << \"4. Class: constructores para inicialización\" << endl;\n    \n    return 0;\n}",
                "mindmap-oop-intro.png",
                "interactive-class-explorer",
                Arrays.asList(
                        new CodeExplanation(1, "struct", "Miembros públicos por defecto"),
                        new CodeExplanation(2, "class", "Miembros privados por defecto"),
                        new CodeExplanation(3, "private:", "No accesible fuera de la clase"),
                        new CodeExplanation(4, "public:", "Accesible desde cualquier parte"),
                        new CodeExplanation(5, "Encapsulación", "Ocultar detalles de implementación"),
                        new CodeExplanation(6, "Constructor", "Método especial para inicializar objetos")
                )
        );
        content7_2_1.setLesson(lesson7_2_1);

        lesson7_2_1.setContent(content7_2_1);
        lessonService.save(lesson7_2_1);

        // ========== MÓDULO 8: ARCHIVOS ==========
        ModuleModel module8 = createModule(
                "Archivos",
                "Aprende a leer, escribir y manipular archivos para persistencia de datos",
                "10 horas", 300, 0, false);
        module8.setCourse(cppCourse);
        moduleService.save(module8);

        // Tema 8.1: Manejo de Archivos
        Topic topic8_1 = createTopic("Manejo de Archivos", false);
        topic8_1.setModule(module8);
        topicService.save(topic8_1);

        // Lección 8.1.1: Lectura de Archivos
        Lesson lesson8_1_1 = createLesson("Lectura de Archivos", "30 min", false, false);
        lesson8_1_1.setTopic(topic8_1);

        LessonContent content8_1_1 = createLessonContent(
                "https://example.com/videos/cpp-file-reading",
                "https://example.com/audio/cpp-file-reading",
                "Lectura_Archivos.pdf",
                "#include <iostream>\n#include <fstream>\n#include <string>\nusing namespace std;\n\nint main() {\n    // Lectura con ifstream\n    ifstream archivo;\n    archivo.open(\"datos.txt\");\n    \n    // Verificar si se abrió correctamente\n    if (!archivo.is_open()) {\n        cout << \"Error al abrir el archivo\" << endl;\n        return 1;\n    }\n    \n    // Lectura palabra por palabra\n    string palabra;\n    cout << \"Contenido (palabra por palabra):\" << endl;\n    while (archivo >> palabra) {\n        cout << palabra << endl;\n    }\n    archivo.close();\n    \n    // Lectura línea por línea\n    archivo.open(\"datos.txt\");\n    string linea;\n    cout << \"\\nContenido (línea por línea):\" << endl;\n    int numLinea = 1;\n    while (getline(archivo, linea)) {\n        cout << numLinea << \": \" << linea << endl;\n        numLinea++;\n    }\n    archivo.close();\n    \n    // Lectura de números\n    ifstream numeros(\"numeros.txt\");\n    if (numeros.is_open()) {\n        int numero;\n        int suma = 0;\n        int contador = 0;\n        \n        cout << \"\\nNúmeros en el archivo:\" << endl;\n        while (numeros >> numero) {\n            cout << numero << \" \";\n            suma += numero;\n            contador++;\n        }\n        cout << endl;\n        \n        if (contador > 0) {\n            cout << \"Suma: \" << suma << endl;\n            cout << \"Promedio: \" << (double)suma / contador << endl;\n        }\n        numeros.close();\n    }\n    \n    // Contar líneas, palabras y caracteres\n    archivo.open(\"datos.txt\");\n    int lineas = 0, palabras = 0, caracteres = 0;\n    \n    while (getline(archivo, linea)) {\n        lineas++;\n        caracteres += linea.length();\n        \n        // Contar palabras\n        bool enPalabra = false;\n        for (char c : linea) {\n            if (isspace(c)) {\n                enPalabra = false;\n            } else if (!enPalabra) {\n                palabras++;\n                enPalabra = true;\n            }\n        }\n    }\n    \n    cout << \"\\nEstadísticas del archivo:\" << endl;\n    cout << \"Líneas: \" << lineas << endl;\n    cout << \"Palabras: \" << palabras << endl;\n    cout << \"Caracteres: \" << caracteres << endl;\n    \n    archivo.close();\n    \n    return 0;\n}",
                "mindmap-file-reading.png",
                "interactive-file-reader",
                Arrays.asList(
                        new CodeExplanation(1, "#include <fstream>", "Biblioteca para manejo de archivos"),
                        new CodeExplanation(2, "ifstream", "Input file stream - lectura"),
                        new CodeExplanation(3, "open()", "Abre el archivo"),
                        new CodeExplanation(4, "is_open()", "Verifica si se abrió correctamente"),
                        new CodeExplanation(5, "getline()", "Lee línea completa"),
                        new CodeExplanation(6, ">>", "Lee palabra o dato formateado"),
                        new CodeExplanation(7, "close()", "Cierra el archivo")
                )
        );
        content8_1_1.setLesson(lesson8_1_1);

        lesson8_1_1.setContent(content8_1_1);
        lessonService.save(lesson8_1_1);

        // Lección 8.1.2: Escritura de Archivos
        Lesson lesson8_1_2 = createLesson("Escritura de Archivos", "28 min", false, false);
        lesson8_1_2.setTopic(topic8_1);

        LessonContent content8_1_2 = createLessonContent(
                "https://example.com/videos/cpp-file-writing",
                "https://example.com/audio/cpp-file-writing",
                "Escritura_Archivos.pdf",
                "#include <iostream>\n#include <fstream>\n#include <string>\nusing namespace std;\n\nint main() {\n    // Escritura básica con ofstream\n    ofstream archivo;\n    archivo.open(\"salida.txt\");\n    \n    if (!archivo.is_open()) {\n        cout << \"Error al crear el archivo\" << endl;\n        return 1;\n    }\n    \n    archivo << \"Hola, este es un archivo de prueba\" << endl;\n    archivo << \"Segunda línea del archivo\" << endl;\n    archivo << \"Números: \" << 42 << \", \" << 3.14 << endl;\n    \n    archivo.close();\n    cout << \"Archivo 'salida.txt' creado exitosamente\" << endl;\n    \n    // Modo append (agregar al final)\n    ofstream log(\"log.txt\", ios::app);\n    if (log.is_open()) {\n        log << \"Nueva entrada en el log\" << endl;\n        log << \"Timestamp: 2025-10-29 15:30:00\" << endl;\n        log.close();\n        cout << \"Log actualizado\" << endl;\n    }\n    \n    // Escribir datos estructurados\n    ofstream estudiantes(\"estudiantes.txt\");\n    if (estudiantes.is_open()) {\n        estudiantes << \"Nombre,Edad,Promedio\" << endl;\n        estudiantes << \"Carlos,20,8.5\" << endl;\n        estudiantes << \"María,22,9.2\" << endl;\n        estudiantes << \"Juan,21,7.8\" << endl;\n        estudiantes.close();\n        cout << \"Archivo CSV creado\" << endl;\n    }\n    \n    // Escribir arreglo de números\n    int numeros[] = {10, 20, 30, 40, 50};\n    ofstream nums(\"numeros.txt\");\n    if (nums.is_open()) {\n        for (int i = 0; i < 5; i++) {\n            nums << numeros[i] << endl;\n        }\n        nums.close();\n        cout << \"Números guardados\" << endl;\n    }\n    \n    // Crear reporte\n    ofstream reporte(\"reporte.txt\");\n    if (reporte.is_open()) {\n        reporte << \"==============================\" << endl;\n        reporte << \"     REPORTE DE VENTAS        \" << endl;\n        reporte << \"==============================\" << endl;\n        reporte << \"Fecha: 29/10/2025\" << endl;\n        reporte << \"------------------------------\" << endl;\n        reporte << \"Producto 1: $150.00\" << endl;\n        reporte << \"Producto 2: $230.50\" << endl;\n        reporte << \"Producto 3: $89.99\" << endl;\n        reporte << \"------------------------------\" << endl;\n        reporte << \"Total: $470.49\" << endl;\n        reporte << \"==============================\" << endl;\n        reporte.close();\n        cout << \"Reporte generado\" << endl;\n    }\n    \n    return 0;\n}",
                "mindmap-file-writing.png",
                "interactive-file-writer",
                Arrays.asList(
                        new CodeExplanation(1, "ofstream", "Output file stream - escritura"),
                        new CodeExplanation(2, "archivo << dato", "Escribe datos en el archivo"),
                        new CodeExplanation(3, "ios::app", "Modo append - agrega al final"),
                        new CodeExplanation(4, "endl", "Salto de línea en archivo"),
                        new CodeExplanation(5, "Sobrescritura", "Por defecto, open() sobrescribe el archivo"),
                        new CodeExplanation(6, "CSV", "Formato común: valores separados por comas")
                )
        );
        content8_1_2.setLesson(lesson8_1_2);

        lesson8_1_2.setContent(content8_1_2);
        lessonService.save(lesson8_1_2);

        // Lección 8.1.3: Manipulación Avanzada
        Lesson lesson8_1_3 = createLesson("Manipulación Avanzada", "32 min", false, false);
        lesson8_1_3.setTopic(topic8_1);

        LessonContent content8_1_3 = createLessonContent(
                "https://example.com/videos/cpp-file-advanced",
                "https://example.com/audio/cpp-file-advanced",
                "Manipulacion_Archivos.pdf",
                "#include <iostream>\n#include <fstream>\n#include <string>\n#include <vector>\nusing namespace std;\n\nstruct Contacto {\n    string nombre;\n    string telefono;\n    string email;\n};\n\nvoid guardarContactos(const vector<Contacto>& contactos, const string& archivo) {\n    ofstream file(archivo);\n    if (file.is_open()) {\n        for (const auto& c : contactos) {\n            file << c.nombre << \"|\" << c.telefono << \"|\" << c.email << endl;\n        }\n        file.close();\n        cout << \"Contactos guardados en \" << archivo << endl;\n    }\n}\n\nvector<Contacto> cargarContactos(const string& archivo) {\n    vector<Contacto> contactos;\n    ifstream file(archivo);\n    \n    if (file.is_open()) {\n        string linea;\n        while (getline(file, linea)) {\n            Contacto c;\n            size_t pos1 = linea.find('|');\n            size_t pos2 = linea.find('|', pos1 + 1);\n            \n            c.nombre = linea.substr(0, pos1);\n            c.telefono = linea.substr(pos1 + 1, pos2 - pos1 - 1);\n            c.email = linea.substr(pos2 + 1);\n            \n            contactos.push_back(c);\n        }\n        file.close();\n    }\n    \n    return contactos;\n}\n\nvoid mostrarContactos(const vector<Contacto>& contactos) {\n    cout << \"\\n===== LISTA DE CONTACTOS =====\" << endl;\n    for (size_t i = 0; i < contactos.size(); i++) {\n        cout << (i+1) << \". \" << contactos[i].nombre << endl;\n        cout << \"   Tel: \" << contactos[i].telefono << endl;\n        cout << \"   Email: \" << contactos[i].email << endl;\n        cout << \"----------------------------\" << endl;\n    }\n}\n\nvoid buscarContacto(const vector<Contacto>& contactos, const string& nombre) {\n    bool encontrado = false;\n    for (const auto& c : contactos) {\n        if (c.nombre.find(nombre) != string::npos) {\n            cout << \"\\nContacto encontrado:\" << endl;\n            cout << \"Nombre: \" << c.nombre << endl;\n            cout << \"Teléfono: \" << c.telefono << endl;\n            cout << \"Email: \" << c.email << endl;\n            encontrado = true;\n        }\n    }\n    if (!encontrado) {\n        cout << \"No se encontró ningún contacto con ese nombre\" << endl;\n    }\n}\n\nint main() {\n    vector<Contacto> agenda;\n    \n    // Agregar contactos\n    agenda.push_back({\"Carlos Mendoza\", \"555-1234\", \"carlos@email.com\"});\n    agenda.push_back({\"María López\", \"555-5678\", \"maria@email.com\"});\n    agenda.push_back({\"Juan Pérez\", \"555-9012\", \"juan@email.com\"});\n    \n    // Guardar en archivo\n    guardarContactos(agenda, \"contactos.txt\");\n    \n    // Limpiar y cargar desde archivo\n    agenda.clear();\n    agenda = cargarContactos(\"contactos.txt\");\n    \n    // Mostrar contactos cargados\n    mostrarContactos(agenda);\n    \n    // Buscar contacto\n    buscarContacto(agenda, \"María\");\n    \n    // Lectura/Escritura simultánea con fstream\n    fstream config(\"config.txt\", ios::in | ios::out | ios::app);\n    if (config.is_open()) {\n        config << \"idioma=español\" << endl;\n        config << \"tema=oscuro\" << endl;\n        config.close();\n    }\n    \n    cout << \"\\nSistema de gestión completado\" << endl;\n    \n    return 0;\n}",
                "mindmap-file-advanced.png",
                "interactive-crud-system",
                Arrays.asList(
                        new CodeExplanation(1, "fstream", "Permite lectura y escritura simultánea"),
                        new CodeExplanation(2, "Persistencia", "Guardar datos entre ejecuciones"),
                        new CodeExplanation(3, "Parseo", "Analizar y extraer datos del archivo"),
                        new CodeExplanation(4, "CRUD", "Create, Read, Update, Delete"),
                        new CodeExplanation(5, "Delimitadores", "Usar | o , para separar campos"),
                        new CodeExplanation(6, "substr() + find()", "Extraer datos delimitados")
                )
        );
        content8_1_3.setLesson(lesson8_1_3);

        lesson8_1_3.setContent(content8_1_3);
        lessonService.save(lesson8_1_3);

        // ========== MÓDULO 9: PROYECTO FINAL INTEGRADOR ==========
        ModuleModel module9 = createModule(
                "Proyecto Final Integrador",
                "Aplica todos los conocimientos desarrollando un proyecto completo desde cero",
                "20 horas", 500, 0, false);
        module9.setCourse(cppCourse);
        moduleService.save(module9);

        // Tema 9.1: Desarrollo de Proyecto
        Topic topic9_1 = createTopic("Desarrollo de Proyecto", false);
        topic9_1.setModule(module9);
        topicService.save(topic9_1);

        // Lección 9.1.1: Especificaciones del Proyecto
        Lesson lesson9_1_1 = createLesson("Especificaciones del Proyecto", "45 min", false, false);
        lesson9_1_1.setTopic(topic9_1);

        LessonContent content9_1_1 = createLessonContent(
                "https://example.com/videos/cpp-final-project-specs",
                "https://example.com/audio/cpp-final-project-specs",
                "Especificaciones_Proyecto.pdf",
                "// PROYECTO FINAL: Sistema de Gestión\n// Opciones disponibles:\n\n// 1. SISTEMA DE GESTIÓN DE BIBLIOTECA\n// - Registrar libros (título, autor, año, ISBN)\n// - Prestar y devolver libros\n// - Buscar libros por título o autor\n// - Mostrar estadísticas\n// - Guardar/cargar datos desde archivo\n\n// 2. AGENDA DE CONTACTOS AVANZADA\n// - CRUD completo de contactos\n// - Búsqueda y filtrado\n// - Categorías de contactos\n// - Exportar a CSV\n// - Persistencia en archivos\n\n// 3. SISTEMA DE INVENTARIO\n// - Gestión de productos\n// - Control de stock\n// - Alertas de stock bajo\n// - Reportes de inventario\n// - Base de datos en archivos\n\n// 4. JUEGO DE CONSOLA\n// - Ahorcado con múltiples niveles\n// - Trivia con categorías\n// - Sistema de puntuación\n// - Ranking de jugadores\n// - Guardar progreso\n\n// 5. CALCULADORA CIENTÍFICA\n// - Operaciones básicas y avanzadas\n// - Funciones trigonométricas\n// - Conversiones de unidades\n// - Historial de operaciones\n// - Modo interactivo\n\n// REQUISITOS TÉCNICOS:\n// - Usar funciones para modularizar\n// - Implementar estructuras (struct)\n// - Manejo de arreglos y/o vectores\n// - Lectura y escritura de archivos\n// - Validación de entrada\n// - Menú interactivo\n// - Comentarios y documentación\n// - Manejo de errores",
                "mindmap-project-options.png",
                "interactive-project-planner",
                Arrays.asList(
                        new CodeExplanation(1, "Especificaciones", "Define qué debe hacer el sistema"),
                        new CodeExplanation(2, "Requisitos técnicos", "Conceptos que debes aplicar"),
                        new CodeExplanation(3, "Modularización", "Divide el proyecto en funciones"),
                        new CodeExplanation(4, "Persistencia", "Los datos deben guardarse en archivos"),
                        new CodeExplanation(5, "Validación", "Verifica entradas del usuario")
                )
        );
        content9_1_1.setLesson(lesson9_1_1);

        lesson9_1_1.setContent(content9_1_1);
        lessonService.save(lesson9_1_1);

        // Lección 9.1.2: Ejemplo Base - Sistema de Biblioteca
        Lesson lesson9_1_2 = createLesson("Ejemplo Base - Sistema de Biblioteca", "60 min", false, false);
        lesson9_1_2.setTopic(topic9_1);

        LessonContent content9_1_2 = createLessonContent(
                "https://example.com/videos/cpp-library-system",
                "https://example.com/audio/cpp-library-system",
                "Sistema_Biblioteca_Ejemplo.pdf",
                "#include <iostream>\n#include <fstream>\n#include <vector>\n#include <string>\nusing namespace std;\n\nstruct Libro {\n    int id;\n    string titulo;\n    string autor;\n    int anio;\n    bool prestado;\n};\n\nvector<Libro> biblioteca;\nint siguienteId = 1;\n\nvoid cargarDatos() {\n    ifstream archivo(\"biblioteca.txt\");\n    if (archivo.is_open()) {\n        Libro libro;\n        while (archivo >> libro.id) {\n            archivo.ignore();\n            getline(archivo, libro.titulo);\n            getline(archivo, libro.autor);\n            archivo >> libro.anio >> libro.prestado;\n            archivo.ignore();\n            biblioteca.push_back(libro);\n            if (libro.id >= siguienteId) {\n                siguienteId = libro.id + 1;\n            }\n        }\n        archivo.close();\n        cout << \"Datos cargados: \" << biblioteca.size() << \" libros\" << endl;\n    }\n}\n\nvoid guardarDatos() {\n    ofstream archivo(\"biblioteca.txt\");\n    if (archivo.is_open()) {\n        for (const auto& libro : biblioteca) {\n            archivo << libro.id << endl;\n            archivo << libro.titulo << endl;\n            archivo << libro.autor << endl;\n            archivo << libro.anio << \" \" << libro.prestado << endl;\n        }\n        archivo.close();\n        cout << \"Datos guardados exitosamente\" << endl;\n    }\n}\n\nvoid agregarLibro() {\n    Libro nuevo;\n    nuevo.id = siguienteId++;\n    nuevo.prestado = false;\n    \n    cin.ignore();\n    cout << \"Título: \";\n    getline(cin, nuevo.titulo);\n    cout << \"Autor: \";\n    getline(cin, nuevo.autor);\n    cout << \"Año: \";\n    cin >> nuevo.anio;\n    \n    biblioteca.push_back(nuevo);\n    cout << \"Libro agregado con ID: \" << nuevo.id << endl;\n}\n\nvoid listarLibros() {\n    if (biblioteca.empty()) {\n        cout << \"No hay libros en la biblioteca\" << endl;\n        return;\n    }\n    \n    cout << \"\\n===== CATÁLOGO DE LIBROS =====\" << endl;\n    for (const auto& libro : biblioteca) {\n        cout << \"ID: \" << libro.id << endl;\n        cout << \"Título: \" << libro.titulo << endl;\n        cout << \"Autor: \" << libro.autor << endl;\n        cout << \"Año: \" << libro.anio << endl;\n        cout << \"Estado: \" << (libro.prestado ? \"PRESTADO\" : \"DISPONIBLE\") << endl;\n        cout << \"----------------------------\" << endl;\n    }\n}\n\nvoid prestarLibro() {\n    int id;\n    cout << \"ID del libro a prestar: \";\n    cin >> id;\n    \n    for (auto& libro : biblioteca) {\n        if (libro.id == id) {\n            if (libro.prestado) {\n                cout << \"El libro ya está prestado\" << endl;\n            } else {\n                libro.prestado = true;\n                cout << \"Libro prestado exitosamente\" << endl;\n            }\n            return;\n        }\n    }\n    cout << \"Libro no encontrado\" << endl;\n}\n\nvoid devolverLibro() {\n    int id;\n    cout << \"ID del libro a devolver: \";\n    cin >> id;\n    \n    for (auto& libro : biblioteca) {\n        if (libro.id == id) {\n            if (!libro.prestado) {\n                cout << \"El libro no estaba prestado\" << endl;\n            } else {\n                libro.prestado = false;\n                cout << \"Libro devuelto exitosamente\" << endl;\n            }\n            return;\n        }\n    }\n    cout << \"Libro no encontrado\" << endl;\n}\n\nvoid buscarLibro() {\n    cin.ignore();\n    string busqueda;\n    cout << \"Ingrese título o autor a buscar: \";\n    getline(cin, busqueda);\n    \n    bool encontrado = false;\n    for (const auto& libro : biblioteca) {\n        if (libro.titulo.find(busqueda) != string::npos || \n            libro.autor.find(busqueda) != string::npos) {\n            cout << \"\\nEncontrado:\" << endl;\n            cout << \"ID: \" << libro.id << \" - \" << libro.titulo << endl;\n            cout << \"Autor: \" << libro.autor << \" (\" << libro.anio << \")\" << endl;\n            encontrado = true;\n        }\n    }\n    \n    if (!encontrado) {\n        cout << \"No se encontraron libros\" << endl;\n    }\n}\n\nvoid mostrarEstadisticas() {\n    int total = biblioteca.size();\n    int prestados = 0;\n    \n    for (const auto& libro : biblioteca) {\n        if (libro.prestado) prestados++;\n    }\n    \n    cout << \"\\n===== ESTADÍSTICAS =====\" << endl;\n    cout << \"Total de libros: \" << total << endl;\n    cout << \"Libros prestados: \" << prestados << endl;\n    cout << \"Libros disponibles: \" << (total - prestados) << endl;\n}\n\nint main() {\n    cargarDatos();\n    \n    int opcion;\n    do {\n        cout << \"\\n===== SISTEMA DE BIBLIOTECA =====\" << endl;\n        cout << \"1. Agregar libro\" << endl;\n        cout << \"2. Listar libros\" << endl;\n        cout << \"3. Prestar libro\" << endl;\n        cout << \"4. Devolver libro\" << endl;\n        cout << \"5. Buscar libro\" << endl;\n        cout << \"6. Estadísticas\" << endl;\n        cout << \"7. Guardar y salir\" << endl;\n        cout << \"Opción: \";\n        cin >> opcion;\n        \n        switch(opcion) {\n            case 1: agregarLibro(); break;\n            case 2: listarLibros(); break;\n            case 3: prestarLibro(); break;\n            case 4: devolverLibro(); break;\n            case 5: buscarLibro(); break;\n            case 6: mostrarEstadisticas(); break;\n            case 7:\n                guardarDatos();\n                cout << \"¡Hasta luego!\" << endl;\n                break;\n            default:\n                cout << \"Opción inválida\" << endl;\n        }\n    } while (opcion != 7);\n    \n    return 0;\n}",
                "mindmap-library-system.png",
                "interactive-project-demo",
                Arrays.asList(
                        new CodeExplanation(1, "Estructura modular", "Cada funcionalidad en su propia función"),
                        new CodeExplanation(2, "Persistencia", "Carga y guarda datos en archivo"),
                        new CodeExplanation(3, "Vector de structs", "Almacena colección de libros"),
                        new CodeExplanation(4, "Menú interactivo", "do-while con switch-case"),
                        new CodeExplanation(5, "Búsqueda", "find() para buscar subcadenas"),
                        new CodeExplanation(6, "Validaciones", "Verifica estados antes de modificar")
                )
        );
        content9_1_2.setLesson(lesson9_1_2);

        lesson9_1_2.setContent(content9_1_2);
        lessonService.save(lesson9_1_2);

        // Lección 9.1.3: Guía de Desarrollo y Mejores Prácticas
        Lesson lesson9_1_3 = createLesson("Guía de Desarrollo y Mejores Prácticas", "40 min", false, false);
        lesson9_1_3.setTopic(topic9_1);

        LessonContent content9_1_3 = createLessonContent(
                "https://example.com/videos/cpp-best-practices",
                "https://example.com/audio/cpp-best-practices",
                "Mejores_Practicas_CPP.pdf",
                "// GUÍA DE MEJORES PRÁCTICAS PARA TU PROYECTO\n\n// 1. NOMBRES DESCRIPTIVOS\nint edad;  // ✓ Bueno\nint e;     // ✗ Malo\n\nvoid calcularPromedio();  // ✓ Bueno\nvoid cp();                // ✗ Malo\n\n// 2. CONSTANTES EN MAYÚSCULAS\nconst int MAX_ESTUDIANTES = 100;\nconst double PI = 3.14159;\n\n// 3. COMENTARIOS ÚTILES\n// Calcula el promedio de un arreglo de números\ndouble calcularPromedio(int arr[], int tam) {\n    int suma = 0;\n    for (int i = 0; i < tam; i++) {\n        suma += arr[i];\n    }\n    return static_cast<double>(suma) / tam;\n}\n\n// 4. VALIDACIÓN DE ENTRADA\nvoid leerEdad() {\n    int edad;\n    do {\n        cout << \"Ingrese edad (1-120): \";\n        cin >> edad;\n        if (edad < 1 || edad > 120) {\n            cout << \"Edad inválida. Intente nuevamente.\" << endl;\n        }\n    } while (edad < 1 || edad > 120);\n}\n\n// 5. MANEJO DE ERRORES EN ARCHIVOS\nvoid abrirArchivo(const string& nombre) {\n    ifstream archivo(nombre);\n    if (!archivo.is_open()) {\n        cerr << \"Error: No se pudo abrir \" << nombre << endl;\n        return;\n    }\n    // Procesar archivo...\n    archivo.close();\n}\n\n// 6. FUNCIONES PEQUEÑAS Y ESPECÍFICAS\n// ✓ Bueno: Una función, una tarea\nvoid mostrarMenu() {\n    cout << \"1. Opción 1\" << endl;\n    cout << \"2. Opción 2\" << endl;\n}\n\nint leerOpcion() {\n    int opcion;\n    cin >> opcion;\n    return opcion;\n}\n\n// 7. USAR CONST PARA PARÁMETROS QUE NO CAMBIAN\nvoid mostrarEstudiante(const Estudiante& est) {\n    cout << est.nombre << endl;\n}\n\n// 8. EVITAR NÚMEROS MÁGICOS\n// ✗ Malo\nif (edad > 18) { /* ... */ }\n\n// ✓ Bueno\nconst int EDAD_MAYORIA = 18;\nif (edad > EDAD_MAYORIA) { /* ... */ }\n\n// 9. INDENTACIÓN CONSISTENTE\nvoid ejemplo() {\n    if (condicion) {\n        // código indentado\n        for (int i = 0; i < 10; i++) {\n            // más indentación\n        }\n    }\n}\n\n// 10. CERRAR RECURSOS\nvoid procesarArchivo() {\n    ifstream archivo(\"datos.txt\");\n    // ... procesar ...\n    archivo.close();  // ✓ Siempre cerrar\n}\n\n// CHECKLIST DEL PROYECTO FINAL:\n// □ Código modularizado en funciones\n// □ Nombres descriptivos de variables y funciones\n// □ Comentarios explicativos\n// □ Validación de entrada del usuario\n// □ Manejo de errores (archivos, etc.)\n// □ Persistencia de datos (archivos)\n// □ Menú interactivo funcional\n// □ Uso de estructuras (struct)\n// □ Uso de arreglos/vectores\n// □ Indentación consistente\n// □ Código compila sin errores\n// □ Pruebas de todas las funcionalidades",
                "mindmap-best-practices.png",
                "interactive-code-review",
                Arrays.asList(
                        new CodeExplanation(1, "Nombres descriptivos", "Facilita lectura y mantenimiento"),
                        new CodeExplanation(2, "Comentarios útiles", "Explica el 'por qué', no el 'qué'"),
                        new CodeExplanation(3, "Validación", "Siempre verifica entrada del usuario"),
                        new CodeExplanation(4, "Modularización", "Una función, una responsabilidad"),
                        new CodeExplanation(5, "Manejo de errores", "Anticipa y gestiona problemas"),
                        new CodeExplanation(6, "Constantes", "Usa const para valores que no cambian")
                )
        );
        content9_1_3.setLesson(lesson9_1_3);

        lesson9_1_3.setContent(content9_1_3);
        lessonService.save(lesson9_1_3);

        // Lección 9.1.4: Rúbrica de Evaluación
        Lesson lesson9_1_4 = createLesson("Rúbrica de Evaluación", "20 min", false, false);
        lesson9_1_4.setTopic(topic9_1);

        LessonContent content9_1_4 = createLessonContent(
                "https://example.com/videos/cpp-project-rubric",
                "https://example.com/audio/cpp-project-rubric",
                "Rubrica_Evaluacion.pdf",
                "// RÚBRICA DE EVALUACIÓN DEL PROYECTO FINAL\n// Total: 100 puntos\n\n// 1. FUNCIONALIDAD (40 puntos)\n// - El programa compila sin errores (10 pts)\n// - Todas las funciones principales funcionan (15 pts)\n// - Manejo correcto de casos especiales (10 pts)\n// - El programa no se cuelga ni crashea (5 pts)\n\n// 2. USO DE CONCEPTOS (30 puntos)\n// - Funciones bien implementadas (8 pts)\n// - Uso correcto de estructuras (6 pts)\n// - Arreglos/vectores utilizados apropiadamente (6 pts)\n// - Manejo de archivos funcional (10 pts)\n\n// 3. CALIDAD DEL CÓDIGO (20 puntos)\n// - Nombres descriptivos (5 pts)\n// - Comentarios útiles (5 pts)\n// - Código bien organizado y modular (5 pts)\n// - Indentación y formato consistente (5 pts)\n\n// 4. INTERFAZ DE USUARIO (10 puntos)\n// - Menú claro y fácil de usar (5 pts)\n// - Mensajes informativos y claros (3 pts)\n// - Validación de entrada (2 pts)\n\n// CRITERIOS DE CALIFICACIÓN:\n// 90-100: Excelente - Supera expectativas\n// 80-89:  Muy Bueno - Cumple todos los requisitos\n// 70-79:  Bueno - Cumple requisitos básicos\n// 60-69:  Suficiente - Funcionalidad limitada\n// <60:    Insuficiente - No cumple requisitos\n\n// ENTREGABLES:\n// 1. Código fuente (.cpp)\n// 2. Archivo README.txt con:\n//    - Instrucciones de compilación\n//    - Cómo usar el programa\n//    - Funcionalidades implementadas\n//    - Problemas conocidos (si hay)\n// 3. Archivos de datos de prueba (si aplica)",
                "mindmap-evaluation.png",
                "interactive-rubric-checker",
                Arrays.asList(
                        new CodeExplanation(1, "Funcionalidad", "Lo más importante: que funcione"),
                        new CodeExplanation(2, "Conceptos", "Demuestra lo aprendido en el curso"),
                        new CodeExplanation(3, "Calidad", "Código limpio y mantenible"),
                        new CodeExplanation(4, "UX", "Experiencia del usuario"),
                        new CodeExplanation(5, "Documentación", "README explica el proyecto")
                )
        );
        content9_1_4.setLesson(lesson9_1_4);

        lesson9_1_4.setContent(content9_1_4);
        lessonService.save(lesson9_1_4);

        System.out.println("✅ Curso de C++ creado exitosamente con todos los módulos, temas y lecciones");
    }

    //----------------------------------------------------------------
    // Métodos auxiliares para crear entidades
    private ModuleModel createModule(String title, String description, String duration, Integer points, Integer progress, Boolean completed) {
        return ModuleModel.builder()
                .title(title)
                .description(description)
                .duration(duration)
                .points(points)
                .progress(progress)
                .completed(completed)
                .build();
    }

    private Topic createTopic(String title, Boolean completed) {
        return Topic.builder()
                .title(title)
                .completed(completed)
                .build();
    }

    private Lesson createLesson(String title, String duration, Boolean completed, Boolean isPreview) {
        return Lesson.builder()
                .title(title)
                .duration(duration)
                .completed(completed)
                .isPreview(isPreview)
                .build();
    }

    private LessonContent createLessonContent(String video, String audio, String document, String code,
            String mindmap, String interactive, List<CodeExplanation> explanations) {
        LessonContent content = LessonContent.builder()
                .video(video)
                .audio(audio)
                .document(document)
                .code(code)
                .mindmap(mindmap)
                .interactive(interactive)
                .codeExplanations(explanations)
                .build();

        return content;
    }

    private Course createCourse(String title, String desc, String cat, String level, Double rating,
            String duration, Integer students, Integer lessons, Integer completedLessons,
            String nextLesson, String thumbnail, String image, String price, String originalPrice,
            Integer xp, Boolean isNew, Boolean isTrending,
            List<String> learningPoints, List<String> requirements, List<String> tags,
            Instructor instructor) {

        Course c = new Course();
        c.setImage(image);
        c.setTitle(title);
        c.setDescription(desc);
        c.setCategory(cat);
        c.setLevel(level);
        c.setRating(rating);
        c.setDuration(duration);
        c.setStudents(students);
        c.setLessons(lessons);
        c.setThumbnail(thumbnail);
        c.setPrice(price);
        c.setOriginalPrice(originalPrice);
        c.setXp(xp);
        c.setIsNew(isNew);
        c.setIsTrending(isTrending);

        c.setLearningPoints(learningPoints);
        c.setRequirements(requirements);
        c.setTags(tags);
        c.setTotalPoints(xp);
        c.setDifficulty(level);

        // Asignar el instructor directamente (ya está attached porque viene de la lista)
        c.setInstructor(instructor);

        return c;
    }

    private void initExamResults() {
        List<ExamResults> results = Arrays.asList(
                createExamResult(95.0, 20, 19, "45:30", true),
                createExamResult(78.5, 30, 24, "62:15", true),
                createExamResult(88.0, 25, 22, "55:40", true),
                createExamResult(92.5, 40, 37, "89:20", true),
                createExamResult(65.0, 20, 13, "38:50", false),
                createExamResult(100.0, 15, 15, "25:10", true),
                createExamResult(82.0, 50, 41, "105:45", true),
                createExamResult(75.5, 30, 23, "67:30", true)
        );
        results.forEach(examResultsService::save);
    }

    private ExamResults createExamResult(Double score, Integer total, Integer correct, String time, Boolean passed) {
        ExamResults er = new ExamResults();
        er.setScore(score);
        er.setTotalQuestions(total);
        er.setCorrectAnswers(correct);
        er.setTimeSpent(time);
        er.setPassed(passed);
        return er;
    }

    private void initFeaturedUsers() {
        List<FeaturedUser> users = Arrays.asList(
                createFeaturedUser("CodeMaster_92", "👨‍💻", "Diamante", 15420, "🏆🔥💎", true),
                createFeaturedUser("DevQueen", "👩‍💻", "Platino", 12350, "⭐🎯🚀", true),
                createFeaturedUser("AlgoWizard", "🧙‍♂️", "Oro", 9870, "✨💡🏅", false),
                createFeaturedUser("ByteNinja", "🥷", "Platino", 11240, "⚡🎖️🔱", true),
                createFeaturedUser("ReactGuru", "👨‍🏫", "Diamante", 14580, "⚛️🏆👑", false),
                createFeaturedUser("PythonQueen", "👸", "Oro", 10120, "🐍💎✨", true),
                createFeaturedUser("DataNinja", "📊", "Platino", 12670, "📈⚡🏆", true),
                createFeaturedUser("CloudMaster", "☁️", "Diamante", 13340, "☁️👑💎", true)
        );
        users.forEach(featuredUserService::save);
    }

    private FeaturedUser createFeaturedUser(String name, String avatar, String level, Integer points, String badges, Boolean online) {
        FeaturedUser fu = new FeaturedUser();
        fu.setName(name);
        fu.setAvatar(avatar);
        fu.setLevel(level);
        fu.setPoints(points);
        fu.setBadges(badges);
        fu.setOnline(online);
        return fu;
    }

    private void initLearningMethods() {
        List<LearningMethod> methods = Arrays.asList(
                createLearningMethod("video", "Video Tutoriales", "🎥", "#3B82F6", "Aprende viendo tutoriales paso a paso con ejemplos prácticos"),
                createLearningMethod("audio", "Podcasts y Audio", "🎧", "#10B981", "Escucha lecciones mientras haces otras actividades"),
                createLearningMethod("text", "Lectura y Documentación", "📚", "#F59E0B", "Lee documentación técnica y artículos detallados"),
                createLearningMethod("practice", "Práctica de Código", "💻", "#8B5CF6", "Aprende haciendo: escribe código y resuelve problemas"),
                createLearningMethod("interactive", "Ejercicios Interactivos", "🎮", "#EF4444", "Completa desafíos interactivos y gamificados"),
                createLearningMethod("project", "Proyectos Reales", "🚀", "#06B6D4", "Construye proyectos completos del mundo real"),
                createLearningMethod("visual", "Diagramas y Mapas", "🗺️", "#EC4899", "Visualiza conceptos con diagramas y mapas mentales"),
                createLearningMethod("ai", "Tutor con IA", "🤖", "#6366F1", "Obtén ayuda instantánea de un tutor con inteligencia artificial")
        );
        methods.forEach(learningMethodService::save);
    }

    private LearningMethod createLearningMethod(String id, String name, String icon, String color, String desc) {
        LearningMethod lm = new LearningMethod();
        lm.setId(id);
        lm.setName(name);
        lm.setIcon(icon);
        lm.setColor(color);
        lm.setDescription(desc);
        return lm;
    }

    private void initMenuItems() {
        List<MenuItem> items = Arrays.asList(
                createMenuItem("dashboard", "Dashboard", "🏠", "/dashboard", null, false),
                createMenuItem("courses", "Mis Cursos", "📚", "/courses", 3, false),
                createMenuItem("projects", "Proyectos", "🚀", "/projects", null, true),
                createMenuItem("challenges", "Desafíos", "⚔️", "/challenges", 5, false),
                createMenuItem("career", "Ruta Profesional", "🎯", "/career", null, false),
                createMenuItem("community", "Comunidad", "👥", "/community", 12, false),
                createMenuItem("achievements", "Logros", "🏆", "/achievements", null, false),
                createMenuItem("premium", "Premium", "💎", "/premium", null, true)
        );
        items.forEach(menuItemService::save);
    }

    private MenuItem createMenuItem(String id, String label, String icon, String path, Integer badge, Boolean isNew) {
        MenuItem mi = new MenuItem();
        mi.setId(id);
        mi.setLabel(label);
        mi.setIcon(icon);
        mi.setPath(path);
        mi.setBadge(badge);
        mi.setIsNew(isNew);
        return mi;
    }

    private OptionForm createOptionForm(String title, String description, String icon, String learningStyle) {
        OptionForm of = new OptionForm();
        of.setTitle(title);
        of.setDescription(description);
        of.setIcon(icon);
        of.setLearningStyle(learningStyle);
        return of;
    }

    private void initPowers() {
        List<Power> powers = Arrays.asList(
                createPower("Doble XP", "Duplica los puntos de experiencia ganados", 4.99, "24 horas", 1, false, true, "#FFD700", "⚡", 24),
                createPower("Racha Congelada", "Protege tu racha de aprendizaje por un día", 2.99, "Uso único", 3, false, true, "#00CED1", "❄️", 20),
                createPower("Pista del Mentor", "Obtén una pista valiosa en cualquier desafío", 1.99, "Uso único", 5, true, false, "#FF6B6B", "💡", 18),
                createPower("Revisión Instantánea", "Recibe feedback inmediato de tu código", 3.99, "3 usos", 0, false, false, "#9D4EDD", "✅", 22),
                createPower("Energía Infinita", "Sin límite de intentos en desafíos", 9.99, "7 días", 0, false, true, "#FF9800", "♾️", 26),
                createPower("Boost de Velocidad", "Reduce el tiempo de espera en lecciones", 5.99, "48 horas", 2, true, false, "#4CAF50", "🚀", 20),
                createPower("Escudo de Protección", "Evita perder puntos por respuestas incorrectas", 6.99, "24 horas", 1, false, false, "#2196F3", "🛡️", 24),
                createPower("Visión del Código", "Muestra soluciones ejemplares de otros usuarios", 7.99, "5 usos", 0, false, true, "#E91E63", "👁️", 22)
        );
        powers.forEach(powerService::save);
    }

    private Power createPower(String name, String desc, Double price, String duration, Integer uses, Boolean owned, Boolean featured, String color, String icon, Integer iconSize) {
        Power p = new Power();
        p.setName(name);
        p.setDescription(desc);
        p.setPrice(price);
        p.setDuration(duration);
        p.setUses(uses);
        p.setOwned(owned);
        p.setIsFeatured(featured);
        p.setColor(color);
        p.setIcon(icon);
        p.setIconSize(iconSize);
        return p;
    }

    private void initPremiumPlans() {
        List<PremiumPlan> plans = Arrays.asList(
                createPremiumPlan("Básico", "Perfecto para comenzar tu viaje", "$9.99", "mes", null, false,
                        Arrays.asList("Acceso a cursos básicos", "5 proyectos guiados", "Chat con IA limitado", "Certificado de finalización")),
                createPremiumPlan("Pro", "Para estudiantes serios", "$19.99", "mes", "Ahorra 20%", true,
                        Arrays.asList("Acceso a todos los cursos", "Proyectos ilimitados", "Chat con IA ilimitado", "Revisión de código por mentores", "Certificados verificados", "Sin anuncios")),
                createPremiumPlan("Elite", "Máxima experiencia de aprendizaje", "$39.99", "mes", "Ahorra 30%", false,
                        Arrays.asList("Todo lo de Pro", "Mentoría 1-a-1", "Preparación para entrevistas", "Acceso a workshops exclusivos", "Portfolio profesional", "Prioridad en soporte")),
                createPremiumPlan("Estudiante", "Precio especial para estudiantes", "$7.99", "mes", "Descuento 40%", false,
                        Arrays.asList("Acceso a cursos principales", "10 proyectos", "Chat con IA", "Certificados", "Verificación de estudiante requerida")),
                createPremiumPlan("Anual Pro", "El mejor valor del año", "$199.99", "año", "Ahorra $40", true,
                        Arrays.asList("Todo lo de Pro", "2 meses gratis", "Acceso anticipado a cursos", "Eventos exclusivos")),
                createPremiumPlan("Empresarial", "Para equipos de desarrollo", "$299.99", "mes", "5-20 usuarios", false,
                        Arrays.asList("Todo lo de Elite", "Dashboard de equipo", "Reportes de progreso", "Contenido personalizado", "Soporte prioritario 24/7")),
                createPremiumPlan("Lifetime", "Acceso de por vida", "$999.99", "único", "Pago único", false,
                        Arrays.asList("Acceso ilimitado de por vida", "Todos los cursos futuros", "Mentoría incluida", "Sin renovaciones")),
                createPremiumPlan("Trial", "Prueba gratuita", "$0.00", "14 días", "Sin tarjeta", false,
                        Arrays.asList("Prueba todas las funciones Pro", "14 días gratis", "Cancela cuando quieras", "Sin compromiso"))
        );
        plans.forEach(premiumPlanService::save);
    }

    private PremiumPlan createPremiumPlan(String name, String desc, String price, String period, String savings, Boolean recommended, List<String> features) {
        PremiumPlan pp = new PremiumPlan();
        pp.setName(name);
        pp.setDescription(desc);
        pp.setPrice(price);
        pp.setPeriod(period);
        pp.setSavings(savings);
        pp.setRecommended(recommended);
        pp.setFeatures(features);
        return pp;
    }

    private void initProducts() {
        List<Product> products = Arrays.asList(
                createProduct("Avatar Legendario: Dragón", "Avatar exclusivo con efectos animados", 299.99, "Avatar", "Legendario", false, true, "dragon-avatar.png", "#FF6B6B", "🐉", 32),
                createProduct("Tema Oscuro Premium", "Tema personalizado para la interfaz", 49.99, "Tema", "Épico", true, false, "dark-theme.png", "#1a1a2e", "🌙", 24),
                createProduct("Marco Dorado", "Marco especial para tu perfil", 79.99, "Marco", "Raro", false, false, "golden-frame.png", "#FFD700", "🖼️", 28),
                createProduct("Boost XP Permanente +10%", "Gana 10% más XP en todas las actividades", 199.99, "Boost", "Épico", false, true, "xp-boost.png", "#00FF88", "⚡", 26),
                createProduct("Insignia de Fundador", "Insignia especial de los primeros usuarios", 499.99, "Insignia", "Mítico", false, true, "founder-badge.png", "#9D4EDD", "👑", 30),
                createProduct("Pack de Emojis Coding", "30 emojis exclusivos de programación", 29.99, "Emojis", "Común", true, false, "emoji-pack.png", "#F59E0B", "😎", 20),
                createProduct("Certificado Holográfico", "Certificado con efecto holográfico", 149.99, "Certificado", "Legendario", false, false, "holo-cert.png", "#00CED1", "📜", 28),
                createProduct("Mascota Virtual: Bytey", "Mascota que te acompaña mientras programas", 89.99, "Mascota", "Épico", false, true, "bytey.png", "#4CAF50", "🤖", 26)
        );
        products.forEach(productService::save);
    }

    private Product createProduct(String name, String desc, Double price, String type, String rarity, Boolean owned, Boolean featured, String image, String color, String icon, Integer iconSize) {
        Product p = new Product();
        p.setName(name);
        p.setDescription(desc);
        p.setPrice(price);
        p.setType(type);
        p.setRarity(rarity);
        p.setOwned(owned);
        p.setIsFeatured(featured);
        p.setImage(image);
        p.setColor(color);
        p.setIcon(icon);
        p.setIconSize(iconSize);
        return p;
    }

    private void initProjects() {
        List<Project> projects = Arrays.asList(
                createProject("Sistema de Gestión de Reservas de Hotel", "Aplicación web completa para gestionar reservas",
                        "Desarrolla un sistema completo de reservas con autenticación, pagos y panel administrativo",
                        Project.ProjectType.GUIADO, Project.Difficulty.INTERMEDIO, "40 horas", 1200, 800, 400, true, 45, Project.ProjectStatus.EN_PROGRESO),
                createProject("Red Social para Desarrolladores", "Plataforma estilo LinkedIn para programadores",
                        "Crea una red social con perfiles, posts, mensajería y sistema de conexiones",
                        Project.ProjectType.LIBRE, Project.Difficulty.AVANZADO, "60 horas", 1800, 1200, 600, true, 0, Project.ProjectStatus.NO_INICIADO),
                createProject("API de E-commerce con Microservicios", "Backend escalable para tienda online",
                        "Implementa una arquitectura de microservicios con Docker y Kubernetes",
                        Project.ProjectType.DESAFIO_IA, Project.Difficulty.EXPERTO, "80 horas", 2500, 1800, 700, true, 20, Project.ProjectStatus.EN_PROGRESO),
                createProject("App Móvil de Fitness Tracker", "Aplicación móvil multiplataforma",
                        "Desarrolla una app de seguimiento de ejercicios con gráficas y notificaciones",
                        Project.ProjectType.GUIADO, Project.Difficulty.INTERMEDIO, "35 horas", 1000, 700, 300, false, 60, Project.ProjectStatus.EN_PROGRESO),
                createProject("Dashboard Analítico con Visualizaciones", "Panel de control con D3.js y Chart.js",
                        "Crea visualizaciones interactivas de datos en tiempo real",
                        Project.ProjectType.LIBRE, Project.Difficulty.INTERMEDIO, "25 horas", 800, 600, 200, false, 100, Project.ProjectStatus.COMPLETADO),
                createProject("Chatbot con IA y NLP", "Asistente virtual inteligente",
                        "Construye un chatbot usando técnicas de procesamiento de lenguaje natural",
                        Project.ProjectType.DESAFIO_IA, Project.Difficulty.AVANZADO, "50 horas", 1500, 1000, 500, true, 0, Project.ProjectStatus.NO_INICIADO),
                createProject("Sistema de Blog con CMS", "Blog profesional con panel de administración",
                        "Desarrolla un CMS completo con editor rich text y gestión de medios",
                        Project.ProjectType.GUIADO, Project.Difficulty.PRINCIPIANTE, "30 horas", 700, 500, 200, false, 75, Project.ProjectStatus.EN_PROGRESO),
                createProject("Plataforma de Streaming de Video", "Clone de YouTube/Netflix",
                        "Crea una plataforma de streaming con transcoding y CDN",
                        Project.ProjectType.COLABORATIVO, Project.Difficulty.EXPERTO, "100 horas", 3000, 2000, 1000, true, 15, Project.ProjectStatus.EN_PROGRESO)
        );
        projects.forEach(projectService::save);
    }

    private Project createProject(String title, String subtitle, String desc, Project.ProjectType type,
            Project.Difficulty difficulty, String duration, Integer totalXP, Integer baseXP,
            Integer bonusXP, Boolean iaEval, Integer progress, Project.ProjectStatus status) {
        Project p = new Project();
        p.setTitle(title);
        p.setSubtitle(subtitle);
        p.setDescription(desc);
        p.setType(type);
        p.setDifficulty(difficulty);
        p.setDuration(duration);
        p.setTotalXP(totalXP);
        p.setBaseXP(baseXP);
        p.setBonusXP(bonusXP);
        p.setIaEvaluation(iaEval);
        p.setProgress(progress);
        p.setStatus(status);
        return p;
    }

    private void initQuestions() {
        List<Question> questions = Arrays.asList(
                createQuestion("¿Qué es una variable?", "Una variable es un espacio en memoria para almacenar datos", Question.QuestionType.TEORICA,
                        Arrays.asList("Un espacio de memoria", "Una función", "Una clase", "Un método"),
                        "Un espacio de memoria", null, null, "Las variables son contenedores que almacenan valores en la memoria del programa", false),
                createQuestion("Implementa FizzBuzz", "Escribe una función que imprima FizzBuzz", Question.QuestionType.PRACTICA,
                        null, "function fizzbuzz(n) { /* código */ }", null,
                        "function fizzbuzz(n) {\n  // Tu código aquí\n}",
                        "Recuerda: Fizz para múltiplos de 3, Buzz para 5, FizzBuzz para ambos", false),
                createQuestion("¿Cuál es la complejidad de búsqueda binaria?", "Selecciona la respuesta correcta", Question.QuestionType.TEORICA,
                        Arrays.asList("O(n)", "O(log n)", "O(n²)", "O(1)"),
                        "O(log n)", null, null, "Búsqueda binaria divide el espacio de búsqueda a la mitad en cada paso", false),
                createQuestion("Invertir una cadena", "Escribe código para invertir una cadena", Question.QuestionType.PRACTICA,
                        null, "def reverse_string(s): # código", null,
                        "def reverse_string(s):\n    # Tu código aquí\n    pass",
                        "Puedes usar slicing [::-1] o un bucle", false),
                createQuestion("¿Qué es REST?", "Explica qué es una API REST", Question.QuestionType.TEORICA,
                        Arrays.asList("Un estilo arquitectónico", "Un lenguaje", "Una base de datos", "Un framework"),
                        "Un estilo arquitectónico", null, null, "REST es un estilo de arquitectura para servicios web que usa HTTP", false),
                createQuestion("Encuentra el número mayor", "Implementa una función que encuentre el máximo en un array", Question.QuestionType.PRACTICA,
                        null, "function findMax(arr) { /* código */ }", null,
                        "function findMax(arr) {\n  // Tu código aquí\n}",
                        "Puedes usar Math.max() o iterar el array", false),
                createQuestion("¿Qué es SQL Injection?", "Define qué es SQL Injection", Question.QuestionType.TEORICA,
                        Arrays.asList("Vulnerabilidad de seguridad", "Tipo de base de datos", "Lenguaje de consulta", "Framework"),
                        "Vulnerabilidad de seguridad", null, null, "SQL Injection es cuando código malicioso se inserta en consultas SQL", false),
                createQuestion("Validar un email", "Crea una función que valide un email", Question.QuestionType.PRACTICA,
                        null, "function validateEmail(email) { /* código */ }", null,
                        "function validateEmail(email) {\n  // Tu código aquí con regex\n}",
                        "Usa expresiones regulares para validar el formato", true)
        );
        questions.forEach(questionService::save);
    }

    private Question createQuestion(String title, String text, Question.QuestionType type, List<String> options,
            String correctAnswer, String userAnswer, String codeTemplate, String explanation, Boolean flagged) {
        Question q = new Question();
        q.setTitle(title);
        q.setText(text);
        q.setType(type);
        q.setOptions(options);
        q.setCorrectAnswer(correctAnswer);
        q.setUserAnswer(userAnswer);
        q.setCodeTemplate(codeTemplate);
        q.setExplanation(explanation);
        q.setFlagged(flagged);
        return q;
    }

    private void initQuestionForms() {
        List<QuestionForm> forms = Arrays.asList(
                createQuestionForm("Cuando aprendes algo nuevo, ¿qué método prefieres?", null, Arrays.asList(
                        createOptionForm("Ver demostraciones", "Prefiero ver cómo se hace antes de intentarlo yo mismo", "👀", "Visual"),
                        createOptionForm("Leer instrucciones", "Me gusta leer y entender la teoría primero", "📖", "Lectura"),
                        createOptionForm("Practicar directamente", "Aprendo mejor haciendo y experimentando", "🔧", "Kinestésico"),
                        createOptionForm("Escuchar explicaciones", "Prefiero que me expliquen verbalmente", "🎧", "Auditivo")
                )),
                createQuestionForm("¿Cómo organizas tu tiempo de estudio?", null, Arrays.asList(
                        createOptionForm("Horarios fijos", "Prefiero estudiar a la misma hora todos los días", "⏰", "Estructurado"),
                        createOptionForm("Cuando tengo inspiración", "Estudio cuando me siento motivado y concentrado", "💡", "Flexible"),
                        createOptionForm("Por objetivos", "Planifico en base a metas específicas a alcanzar", "🎯", "Orientado a metas"),
                        createOptionForm("Intensivo", "Prefiero sesiones largas y profundas", "⚡", "Inmersivo")
                )),
                createQuestionForm("¿Qué tipo de material te resulta más útil?", null, Arrays.asList(
                        createOptionForm("Diagramas y mapas mentales", "Me ayudan a ver las conexiones entre conceptos", "🗺️", "Visual"),
                        createOptionForm("Textos y apuntes", "Prefiero material escrito detallado", "📝", "Lectura"),
                        createOptionForm("Ejercicios prácticos", "Aprendo resolviendo problemas reales", "🧩", "Kinestésico"),
                        createOptionForm("Podcasts y audios", "Puedo aprender mientras hago otras actividades", "🎙️", "Auditivo")
                )),
                createQuestionForm("¿Cómo prefieres recibir feedback?", null, Arrays.asList(
                        createOptionForm("Ver ejemplos corregidos", "Comparar mi trabajo con soluciones modelo", "👁️", "Visual"),
                        createOptionForm("Comentarios escritos", "Prefiero feedback detallado por escrito", "✍️", "Lectura"),
                        createOptionForm("Práctica guiada", "Que me muestren cómo mejorar en el momento", "🤝", "Kinestésico"),
                        createOptionForm("Conversaciones", "Discutir mis progresos verbalmente", "💬", "Auditivo")
                )),
                createQuestionForm("¿Qué ambiente te ayuda más a concentrarte?", null, Arrays.asList(
                        createOptionForm("Espacio ordenado y visual", "Me concentro mejor en ambientes organizados", "🧹", "Visual"),
                        createOptionForm("Silencio absoluto", "Necesito eliminar distracciones auditivas", "🤫", "Lectura"),
                        createOptionForm("Poder moverme", "Me ayuda cambiar de postura o lugar", "🚶", "Kinestésico"),
                        createOptionForm("Música de fondo", "El sonido ambiental me ayuda a concentrarme", "🎵", "Auditivo")
                )),
                createQuestionForm("¿Cómo abordas un tema complejo?", null, Arrays.asList(
                        createOptionForm("Dividiendo en partes", "Desgloso el problema en componentes más pequeños", "🧩", "Analítico"),
                        createOptionForm("Buscando el panorama general", "Primero entiendo el concepto global", "🌅", "Global"),
                        createOptionForm("Probando con ejemplos", "Experimentando con casos prácticos", "🔍", "Experimental"),
                        createOptionForm("Preguntando a otros", "Discutiendo el tema con compañeros", "👥", "Social")
                )),
                createQuestionForm("¿Qué tipo de proyectos disfrutas más?", null, Arrays.asList(
                        createOptionForm("Diseño visual", "Crear interfaces y experiencias visuales", "🎨", "Visual"),
                        createOptionForm("Investigación teórica", "Profundizar en conceptos y teorías", "🔬", "Lectura"),
                        createOptionForm("Construcción manual", "Armar cosas con las manos o código", "🛠️", "Kinestésico"),
                        createOptionForm("Presentaciones orales", "Explicar ideas verbalmente", "🎤", "Auditivo")
                )),
                createQuestionForm("¿Cómo tomas apuntes?", null, Arrays.asList(
                        createOptionForm("Con colores y dibujos", "Uso elementos visuales para organizar ideas", "🖍️", "Visual"),
                        createOptionForm("Texto estructurado", "Listas y párrafos organizados", "📑", "Lectura"),
                        createOptionForm("Notas breves", "Apunto solo lo esencial y práctico", "📌", "Kinestésico"),
                        createOptionForm("Grabaciones", "Prefiero grabar y escuchar después", "🎙️", "Auditivo")
                )),
                createQuestionForm("¿Cómo manejas los errores al aprender?", null, Arrays.asList(
                        createOptionForm("Analizando visualmente", "Reviso dónde me equivoqué paso a paso", "🔎", "Visual"),
                        createOptionForm("Buscando en documentación", "Consulto fuentes escritas para entender", "📚", "Lectura"),
                        createOptionForm("Intentando de nuevo", "Práctico hasta que sale bien", "🔄", "Kinestésico"),
                        createOptionForm("Pidiendo explicación", "Pregunto a alguien que me lo explique", "❓", "Auditivo")
                )),
                createQuestionForm("¿Qué te motiva a seguir aprendiendo?", null, Arrays.asList(
                        createOptionForm("Ver progreso visual", "Gráficos y métricas de mi avance", "📊", "Visual"),
                        createOptionForm("Lograr certificaciones", "Obtener reconocimientos formales", "🏆", "Lectura"),
                        createOptionForm("Resolver problemas reales", "Aplicar lo aprendido en proyectos", "💼", "Kinestésico"),
                        createOptionForm("Compartir conocimiento", "Enseñar a otros lo que he aprendido", "🗣️", "Auditivo")
                ))
        );

        forms.forEach(questionFormService::save);
    }

    private QuestionForm createQuestionForm(String question, String subtitle, List<OptionForm> options) {
        QuestionForm qf = new QuestionForm();
        qf.setAnswer("");
        qf.setQuestion(question);
        options.forEach(o -> o.setQuestionForm(qf));

        if (options != null) {
            qf.setOptions(options);
        }

        return qf;
    }

    private void initRequirements() {
        List<Requirement> requirements = Arrays.asList(
                createRequirement("Conocimientos básicos de HTML y CSS", Requirement.RequirementType.CONOCIMIENTO, Requirement.RequirementStatus.COMPLETADO, 1L),
                createRequirement("Completar curso de JavaScript Básico", Requirement.RequirementType.CURSO, Requirement.RequirementStatus.COMPLETADO, 2L),
                createRequirement("Entender programación orientada a objetos", Requirement.RequirementType.CONOCIMIENTO, Requirement.RequirementStatus.EN_PROGRESO, 3L),
                createRequirement("Matemáticas básicas y álgebra", Requirement.RequirementType.CONOCIMIENTO, Requirement.RequirementStatus.COMPLETADO, null),
                createRequirement("Completar curso de Python Fundamentals", Requirement.RequirementType.CURSO, Requirement.RequirementStatus.PENDIENTE, 5L),
                createRequirement("Habilidad para resolver problemas lógicos", Requirement.RequirementType.HABILIDAD, Requirement.RequirementStatus.COMPLETADO, null),
                createRequirement("Conocimientos de bases de datos SQL", Requirement.RequirementType.CONOCIMIENTO, Requirement.RequirementStatus.EN_PROGRESO, 7L),
                createRequirement("Completar proyecto de API REST", Requirement.RequirementType.CURSO, Requirement.RequirementStatus.PENDIENTE, 4L)
        );
        requirements.forEach(requirementService::save);
    }

    private Requirement createRequirement(String desc, Requirement.RequirementType type, Requirement.RequirementStatus status, Long courseId) {
        Requirement r = new Requirement();
        r.setDescription(desc);
        r.setType(type);
        r.setStatus(status);
        r.setCourseId(courseId);
        return r;
    }

    private void initResources() {
        List<ResourceModel> resources = Arrays.asList(
                createResource("Documentación Oficial de React", "Guía completa y actualizada de React", "📄", ResourceModel.ResourceType.DOCUMENTO, "https://react.dev"),
                createResource("Tutorial de Git en Video", "Aprende Git desde cero en 1 hora", "🎥", ResourceModel.ResourceType.VIDEO, "https://youtube.com/git-tutorial"),
                createResource("Repositorio de Ejercicios de Algoritmos", "500+ problemas resueltos en GitHub", "💻", ResourceModel.ResourceType.REPOSITORIO, "https://github.com/algorithms"),
                createResource("Artículo: Clean Code Principles", "Principios para escribir código limpio", "📝", ResourceModel.ResourceType.ARTICULO, "https://blog.com/clean-code"),
                createResource("Documentación de PostgreSQL", "Referencia completa de PostgreSQL", "📄", ResourceModel.ResourceType.DOCUMENTO, "https://postgresql.org/docs"),
                createResource("Curso de Docker en YouTube", "Serie completa de Docker y contenedores", "🎥", ResourceModel.ResourceType.VIDEO, "https://youtube.com/docker-course"),
                createResource("Awesome Python Resources", "Lista curada de recursos de Python", "💻", ResourceModel.ResourceType.REPOSITORIO, "https://github.com/awesome-python"),
                createResource("Artículo: Microservices Architecture", "Guía de arquitectura de microservicios", "📝", ResourceModel.ResourceType.ARTICULO, "https://blog.com/microservices")
        );
        resources.forEach(resourceService::save);
    }

    private ResourceModel createResource(String title, String desc, String icon, ResourceModel.ResourceType type, String url) {
        ResourceModel r = new ResourceModel();
        r.setTitle(title);
        r.setDescription(desc);
        r.setIcon(icon);
        r.setType(type);
        r.setUrl(url);
        return r;
    }

    private void initSkills() {
        List<Skill> skills = Arrays.asList(
                createSkill("JavaScript", 85, 100, Skill.SkillCategory.TECNICA),
                createSkill("Python", 75, 90, Skill.SkillCategory.TECNICA),
                createSkill("React", 70, 85, Skill.SkillCategory.TECNICA),
                createSkill("SQL", 60, 80, Skill.SkillCategory.TECNICA),
                createSkill("Trabajo en Equipo", 80, 90, Skill.SkillCategory.BLANDA),
                createSkill("Resolución de Problemas", 75, 85, Skill.SkillCategory.BLANDA),
                createSkill("Docker", 50, 75, Skill.SkillCategory.TECNICA),
                createSkill("Comunicación", 70, 85, Skill.SkillCategory.BLANDA)
        );
        skills.forEach(skillService::save);
    }

    private Skill createSkill(String name, Integer level, Integer target, Skill.SkillCategory category) {
        Skill s = new Skill();
        s.setName(name);
        s.setCategory(category);
        return s;
    }

    private void initTechnologies() {
        List<Technology> technologies = Arrays.asList(
                createTechnology("React", "⚛️", "Frontend", true),
                createTechnology("Node.js", "🟢", "Backend", true),
                createTechnology("PostgreSQL", "🐘", "Database", true),
                createTechnology("Docker", "🐳", "DevOps", false),
                createTechnology("TypeScript", "🔷", "Language", true),
                createTechnology("MongoDB", "🍃", "Database", false),
                createTechnology("AWS", "☁️", "Cloud", true),
                createTechnology("Python", "🐍", "Language", true)
        );
        technologies.forEach(technologyService::save);
    }

    private Technology createTechnology(String name, String icon, String category, Boolean required) {
        Technology t = new Technology();
        t.setName(name);
        t.setIcon(icon);
        t.setCategory(category);
        t.setRequired(required);
        return t;
    }

    private void initTestCases() {
        List<TestCase> testCases = Arrays.asList(
                createTestCase("Prueba de entrada vacía", "Verificar comportamiento con string vacío", TestCase.TestCaseStatus.PASADO, TestCase.TestCaseType.AUTOMATICO),
                createTestCase("Prueba de números negativos", "Validar manejo de valores negativos", TestCase.TestCaseStatus.PASADO, TestCase.TestCaseType.AUTOMATICO),
                createTestCase("Prueba de caso límite", "Array con un solo elemento", TestCase.TestCaseStatus.FALLADO, TestCase.TestCaseType.AUTOMATICO),
                createTestCase("Prueba de rendimiento", "Verificar tiempo de ejecución con 1M elementos", TestCase.TestCaseStatus.NO_EJECUTADO, TestCase.TestCaseType.PERSONALIZADO),
                createTestCase("Prueba de caracteres especiales", "Validar manejo de Unicode y emojis", TestCase.TestCaseStatus.PASADO, TestCase.TestCaseType.AUTOMATICO),
                createTestCase("Prueba de concurrencia", "Múltiples usuarios simultáneos", TestCase.TestCaseStatus.PASADO, TestCase.TestCaseType.PERSONALIZADO),
                createTestCase("Prueba de SQL injection", "Verificar protección contra inyección SQL", TestCase.TestCaseStatus.FALLADO, TestCase.TestCaseType.AUTOMATICO),
                createTestCase("Prueba de memoria", "Validar no hay memory leaks", TestCase.TestCaseStatus.NO_EJECUTADO, TestCase.TestCaseType.PERSONALIZADO)
        );
        testCases.forEach(testCaseService::save);
    }

    private TestCase createTestCase(String title, String desc, TestCase.TestCaseStatus status, TestCase.TestCaseType type) {
        TestCase tc = new TestCase();
        tc.setTitle(title);
        tc.setDescription(desc);
        tc.setStatus(status);
        tc.setType(type);
        return tc;
    }

    private void initTrends() {
        List<Trend> trends = Arrays.asList(
                createTrend("#JavaScript", 15420, true),
                createTrend("#Python", 12350, true),
                createTrend("#React", 10890, true),
                createTrend("#MachineLearning", 9560, true),
                createTrend("#WebDevelopment", 8740, false),
                createTrend("#DataScience", 7320, true),
                createTrend("#Docker", 6150, false),
                createTrend("#Algorithms", 5890, false)
        );
        trends.forEach(trendService::save);
    }

    private Trend createTrend(String tag, Integer posts, Boolean trending) {
        Trend t = new Trend();
        t.setTag(tag);
        t.setPosts(posts);
        t.setTrending(trending);
        return t;
    }

    private void initPosts() {
        List<Post> posts = Arrays.asList(
                createPost("CodeMaster_92", "👨‍💻", "Diamante", "Hace 2 horas",
                        "¡Finalmente completé mi proyecto de Sistema de Reservas! 🎉 Aprendí muchísimo sobre autenticación JWT y manejo de estados en React. Gracias a todos por el apoyo! 💪",
                        null, 145, false),
                createPost("DevQueen", "👩‍💻", "Platino", "Hace 5 horas",
                        "¿Alguien más está luchando con los conceptos de closures en JavaScript? He visto varios tutoriales pero aún me cuesta entenderlo completamente 🤔",
                        null, 67, true),
                createPost("PythonGuru", "🐍", "Oro", "Hace 1 día",
                        "Acabo de terminar el curso de Machine Learning y WOW! 🤖 Los algoritmos de clasificación son fascinantes. Aquí va mi primer modelo predictivo:",
                        "ml-model-screenshot.png", 203, false),
                createPost("ReactNinja", "⚛️", "Platino", "Hace 3 horas",
                        "Tip del día: Siempre usa useCallback y useMemo con cuidado. La optimización prematura puede hacer tu código más difícil de mantener. ¡Mide primero! 📊",
                        null, 89, true),
                createPost("DataWizard", "📊", "Diamante", "Hace 6 horas",
                        "Terminé mi dashboard de visualización de datos! Usé D3.js para las gráficas interactivas. El proyecto me tomó 3 semanas pero valió totalmente la pena ✨",
                        "dashboard-preview.png", 178, false),
                createPost("BackendKing", "⚙️", "Oro", "Hace 12 horas",
                        "Pregunta: ¿Cuál prefieren para APIs, REST o GraphQL? Estoy evaluando opciones para mi nuevo proyecto y me gustaría escuchar experiencias reales 🤷‍♂️",
                        null, 92, false),
                createPost("CloudMaster", "☁️", "Diamante", "Hace 8 horas",
                        "Acabo de obtener mi certificación de AWS Solutions Architect! 🏆 El examen fue desafiante pero todo el estudio valió la pena. Ahora a por Kubernetes!",
                        "aws-certificate.png", 256, true),
                createPost("SecurityPro", "🔒", "Platino", "Hace 4 horas",
                        "Recordatorio importante: NUNCA almacenes contraseñas en texto plano. Siempre usa bcrypt, argon2 o similar para hashear. La seguridad no es opcional! 🛡️",
                        null, 134, true)
        );
        posts.forEach(postService::save);
    }

    private Post createPost(String user, String avatar, String level, String date, String content,
            String image, Integer likes, Boolean liked) {
        Post p = new Post();
        p.setUser(user);
        p.setAvatar(avatar);
        p.setLevel(level);
        p.setDate(date);
        p.setContent(content);
        p.setImage(image);
        p.setLikes(likes);
        p.setLiked(liked);
        return p;
    }

    private void initProfileUsers() {
        List<UserProfile> users = Arrays.asList(
                createUserProfile(
                        "CodeMaster_92",
                        "👨‍💻",
                        15,
                        15420,
                        20000,
                        "Diamante",
                        Arrays.asList(5L),
                        Arrays.asList(1L, 3L, 4L, 8L),
                        Arrays.asList(10L, 15L),
                        Arrays.asList(2L, 3L, 6L, 9L, 17L),
                        Arrays.asList(1L, 3L, 5L),
                        Arrays.asList(1L),
                        Arrays.asList(3L, 6L),
                        Arrays.asList(1L, 4L, 7L),
                        Arrays.asList(1L, 2L, 4L, 7L),
                        Arrays.asList(3L, 6L)
                ),
                createUserProfile(
                        "DevQueen",
                        "👩‍💻",
                        12,
                        12350,
                        15000,
                        "Platino",
                        Arrays.asList(5L),
                        Arrays.asList(1L, 4L, 7L),
                        Arrays.asList(10L, 15L, 17L),
                        Arrays.asList(2L, 3L, 9L, 18L),
                        Arrays.asList(2L, 4L, 6L),
                        Arrays.asList(2L),
                        Arrays.asList(1L, 7L),
                        Arrays.asList(2L, 5L, 8L),
                        Arrays.asList(1L, 4L, 6L),
                        Arrays.asList(1L, 4L)
                ),
                createUserProfile(
                        "PythonGuru",
                        "🐍",
                        10,
                        9870,
                        12000,
                        "Oro",
                        Arrays.asList(5L, 7L),
                        Arrays.asList(2L, 3L, 6L),
                        Arrays.asList(2L, 10L, 12L, 15L),
                        Arrays.asList(11L, 13L, 16L, 19L),
                        Arrays.asList(7L, 8L),
                        Arrays.asList(3L),
                        Arrays.asList(5L, 8L),
                        Arrays.asList(3L, 6L),
                        Arrays.asList(1L, 3L, 5L, 8L),
                        Arrays.asList(2L, 5L, 7L)
                ),
                createUserProfile(
                        "ReactNinja",
                        "⚛️",
                        11,
                        11240,
                        14000,
                        "Platino",
                        Arrays.asList(5L),
                        Arrays.asList(1L, 2L, 4L, 8L),
                        Arrays.asList(1L, 3L, 9L, 15L),
                        Arrays.asList(14L, 17L, 18L, 20L),
                        Arrays.asList(1L, 3L, 5L),
                        Arrays.asList(7L),
                        Arrays.asList(1L, 2L, 4L),
                        Arrays.asList(4L, 7L),
                        Arrays.asList(2L, 4L, 7L),
                        Arrays.asList(1L, 3L, 8L)
                ),
                createUserProfile(
                        "CloudMaster",
                        "☁️",
                        14,
                        13340,
                        18000,
                        "Diamante",
                        Arrays.asList(5L, 7L),
                        Arrays.asList(3L, 6L, 8L),
                        Arrays.asList(6L, 7L, 10L, 15L, 20L),
                        Arrays.asList(11L, 13L, 16L, 19L),
                        Arrays.asList(2L, 4L, 6L, 8L),
                        Arrays.asList(4L, 8L),
                        Arrays.asList(3L, 5L, 6L),
                        Arrays.asList(5L, 8L),
                        Arrays.asList(4L, 7L, 8L),
                        Arrays.asList(1L, 4L, 5L, 7L)
                )
        );
        users.forEach(userProfileService::save);
    }

    private UserProfile createUserProfile(String name, String avatar, Integer level, Integer xp, Integer maxXp,
            String rank, List<Long> projectsDone, List<Long> projectsInProgress,
            List<Long> coursesDone, List<Long> coursesInProgress, List<Long> reviews,
            List<Long> carrerPathsDone, List<Long> carrerPathsInProgress,
            List<Long> posts, List<Long> badges, List<Long> powers) {
        UserProfile user = new UserProfile();
        user.setName(name);
        user.setAvatar(avatar);
        user.setLevel(level);
        user.setXp(xp);
        user.setMaxXp(maxXp);
        user.setRank(rank);
        return user;
    }
}
