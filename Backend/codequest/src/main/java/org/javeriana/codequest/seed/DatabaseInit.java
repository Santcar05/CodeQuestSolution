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
                createInstructor("Roberto Silva", "👨‍💼")
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
                        "$49.99", "$89.99", 850, true, true, Course.CourseStatus.NOT_STARTED,
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
                        "$79.99", "$129.99", 1200, true, true, Course.CourseStatus.IN_PROGRESS,
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
                        "$69.99", "$119.99", 950, true, true, Course.CourseStatus.IN_PROGRESS,
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
                        "$59.99", "$99.99", 800, false, true, Course.CourseStatus.NOT_STARTED,
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
                        "$64.99", "$109.99", 900, true, false, Course.CourseStatus.NOT_STARTED,
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
                        "$89.99", "$149.99", 700, false, true, Course.CourseStatus.IN_PROGRESS,
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
                        "$74.99", "$124.99", 850, true, true, Course.CourseStatus.NOT_STARTED,
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
                        "$99.99", "$169.99", 1500, false, false, Course.CourseStatus.NOT_STARTED,
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
                        "$54.99", "$94.99", 750, true, false, Course.CourseStatus.IN_PROGRESS,
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
                        "Gratis", null, 600, false, false, Course.CourseStatus.COMPLETED,
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
                        "$59.99", "$99.99", 800, false, true, Course.CourseStatus.NOT_STARTED,
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
                        "$89.99", "$159.99", 1400, true, true, Course.CourseStatus.NOT_STARTED,
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
                        "$69.99", "$119.99", 900, false, false, Course.CourseStatus.NOT_STARTED,
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
                        "$79.99", "$139.99", 1100, true, false, Course.CourseStatus.NOT_STARTED,
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
                        "Gratis", null, 400, false, false, Course.CourseStatus.COMPLETED,
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
                        "$74.99", "$129.99", 1000, false, true, Course.CourseStatus.NOT_STARTED,
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
                        "$49.99", "$89.99", 550, true, false, Course.CourseStatus.IN_PROGRESS,
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
                        "$69.99", "$119.99", 950, false, true, Course.CourseStatus.NOT_STARTED,
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
                        "$54.99", "$94.99", 700, true, false, Course.CourseStatus.NOT_STARTED,
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
                        "$79.99", "$139.99", 850, false, true, Course.CourseStatus.NOT_STARTED,
                        Arrays.asList("Azure Pipelines", "Terraform", "Kubernetes en Azure", "Monitoring", "Security"),
                        Arrays.asList("Conceptos de cloud", "Linux", "Scripting básico"),
                        Arrays.asList("Azure", "DevOps", "Cloud"),
                        instructors.get(3) // Juan Pérez
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
        lessonService.save(lesson1_1_1);

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
        content1_1_1.setLesson(lesson1_1_1);
        lessonContentService.save(content1_1_1);

        Lesson lesson1_1_2 = createLesson("Staging y Commits Efectivos", "20 min", true, false);
        lesson1_1_2.setTopic(topic1_1);
        lessonService.save(lesson1_1_2);

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
        content1_1_2.setLesson(lesson1_1_2);
        lessonContentService.save(content1_1_2);

        // Tema 1.2: Ramas y Merging
        Topic topic1_2 = createTopic("Manejo Avanzado de Ramas", true);
        topic1_2.setModule(module1);
        topicService.save(topic1_2);

        Lesson lesson1_2_1 = createLesson("Creación y Navegación de Ramas", "18 min", true, false);
        lesson1_2_1.setTopic(topic1_2);
        lessonService.save(lesson1_2_1);

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
        content1_2_1.setLesson(lesson1_2_1);
        lessonContentService.save(content1_2_1);

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
        lessonService.save(lesson2_1_1);

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
        content2_1_1.setLesson(lesson2_1_1);
        lessonContentService.save(content2_1_1);

        Lesson lesson2_1_2 = createLesson("Ramas Principales: main, develop, features", "30 min", false, false);
        lesson2_1_2.setTopic(topic2_1);
        lessonService.save(lesson2_1_2);

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
        content2_1_2.setLesson(lesson2_1_2);
        lessonContentService.save(content2_1_2);

        // Tema 2.2: GitHub Flow
        Topic topic2_2 = createTopic("GitHub Flow: Workflow Simplificado", false);
        topic2_2.setModule(module2);
        topicService.save(topic2_2);

        Lesson lesson2_2_1 = createLesson("Pull Requests y Code Review", "35 min", false, false);
        lesson2_2_1.setTopic(topic2_2);
        lessonService.save(lesson2_2_1);

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
        content2_2_1.setLesson(lesson2_2_1);
        lessonContentService.save(content2_2_1);

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
        lessonService.save(lesson3_1_1);

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
        content3_1_1.setLesson(lesson3_1_1);
        lessonContentService.save(content3_1_1);

        Lesson lesson3_1_2 = createLesson("Herramientas de Resolución", "28 min", false, false);
        lesson3_1_2.setTopic(topic3_1);
        lessonService.save(lesson3_1_2);

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
        content3_1_2.setLesson(lesson3_1_2);
        lessonContentService.save(content3_1_2);

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
        lessonService.save(lesson4_1_1);

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
        content4_1_1.setLesson(lesson4_1_1);
        lessonContentService.save(content4_1_1);

        // Tema 4.2: Integración CI/CD
        Topic topic4_2 = createTopic("Git en Pipelines de CI/CD", false);
        topic4_2.setModule(module4);
        topicService.save(topic4_2);

        Lesson lesson4_2_1 = createLesson("GitHub Actions para Automatización", "40 min", false, false);
        lesson4_2_1.setTopic(topic4_2);
        lessonService.save(lesson4_2_1);

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
        content4_2_1.setLesson(lesson4_2_1);
        lessonContentService.save(content4_2_1);

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
        lessonService.save(lesson5_1_1);

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
        content5_1_1.setLesson(lesson5_1_1);
        lessonContentService.save(content5_1_1);
    }

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
            Integer xp, Boolean isNew, Boolean isTrending, Course.CourseStatus status,
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
        c.setCompletedLessons(completedLessons);
        c.setNextLesson(nextLesson);
        c.setThumbnail(thumbnail);
        c.setPrice(price);
        c.setOriginalPrice(originalPrice);
        c.setXp(xp);
        c.setIsNew(isNew);
        c.setIsTrending(isTrending);
        c.setStatus(status);
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
