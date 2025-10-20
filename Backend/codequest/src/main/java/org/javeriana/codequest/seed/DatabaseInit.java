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
import org.javeriana.codequest.entity.MenuItem;
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
import org.javeriana.codequest.entity.Trend;
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
import org.javeriana.codequest.service.entity.MenuItemService;
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
import org.javeriana.codequest.service.entity.TrendService;
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

    //@Autowired
    //private LessonService lessonService;
    //@Autowired
    //private LessonContentService lessonContentService;
    @Autowired
    private MenuItemService menuItemService;

    //@Autowired
    //private ModuleModelService moduleService;
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
    /*
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RoadmapItemService roadmapItemService;

    @Autowired
    private RoadmapPhaseService roadmapPhaseService;
     */
    @Autowired
    private SkillService skillService;

    @Autowired
    private TechnologyService technologyService;

    @Autowired
    private TestCaseService testCaseService;

//    @Autowired
//    private TopicService topicService;
    @Autowired
    private TrendService trendService;

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
        List<Course> courses = Arrays.asList(
                createCourse("Introducción a la Programación con C++", "Aprende C++ desde cero", "Programación", "Principiante",
                        4.7, "45 horas", 8420, 90, 0, "Variables y Tipos de Datos", "cpp-intro.jpg", "Gratis", null, 550, true, false, Course.CourseStatus.NOT_STARTED,
                        Arrays.asList("Sintaxis de C++", "POO", "Punteros", "STL"),
                        Arrays.asList("Conocimientos básicos de computación"),
                        Arrays.asList("C++", "Programming", "Beginner")),
                createCourse("Desarrollo Web con React", "Construye aplicaciones web modernas", "Frontend", "Intermedio",
                        4.9, "50 horas", 18650, 150, 45, "Hooks y Estado", "react-course.jpg", "$59.99", "$99.99", 750, true, true, Course.CourseStatus.IN_PROGRESS,
                        Arrays.asList("Componentes y Props", "Hooks", "Context API", "React Router"),
                        Arrays.asList("HTML, CSS, JavaScript básico"),
                        Arrays.asList("React", "Frontend", "JavaScript")),
                createCourse("Python para Ciencia de Datos", "Análisis de datos con Python", "Data Science", "Intermedio",
                        4.8, "55 horas", 10340, 145, 58, "Pandas y NumPy", "python-datascience.jpg", "$64.99", "$109.99", 800, true, true, Course.CourseStatus.IN_PROGRESS,
                        Arrays.asList("NumPy", "Pandas", "Matplotlib", "Análisis exploratorio"),
                        Arrays.asList("Python básico"),
                        Arrays.asList("Python", "DataScience", "Analytics")),
                createCourse("Desarrollo de APIs REST con Node.js", "Backend profesional", "Backend", "Intermedio",
                        4.6, "45 horas", 9870, 95, 0, "Creación de APIs", "nodejs-express.jpg", "$54.99", "$89.99", 700, false, false, Course.CourseStatus.NOT_STARTED,
                        Arrays.asList("APIs RESTful", "Middleware", "Autenticación JWT", "Base de datos"),
                        Arrays.asList("JavaScript intermedio"),
                        Arrays.asList("NodeJS", "Backend", "API")),
                createCourse("Introducción a Machine Learning", "Aprendizaje automático con Python", "AI/ML", "Avanzado",
                        4.7, "70 horas", 7890, 210, 0, "Regresión Lineal", "ml-python.jpg", "$79.99", "$139.99", 1000, false, true, Course.CourseStatus.NOT_STARTED,
                        Arrays.asList("Scikit-learn", "Regresión", "Clasificación", "Clustering"),
                        Arrays.asList("Python, matemáticas básicas, estadística"),
                        Arrays.asList("MachineLearning", "AI", "Python")),
                createCourse("Desarrollo Móvil con Flutter", "Apps multiplataforma", "Mobile", "Principiante",
                        4.9, "45 horas", 12450, 125, 0, "Widgets básicos", "flutter.jpg", "$54.99", "$89.99", 700, true, true, Course.CourseStatus.NOT_STARTED,
                        Arrays.asList("Dart", "Widgets", "State Management", "Firebase"),
                        Arrays.asList("Programación básica"),
                        Arrays.asList("Flutter", "Dart", "Mobile")),
                createCourse("Bases de Datos con PostgreSQL", "SQL avanzado y optimización", "Backend", "Intermedio",
                        4.7, "35 horas", 11250, 78, 78, "Normalización", "postgresql.jpg", "Gratis", null, 500, false, false, Course.CourseStatus.COMPLETED,
                        Arrays.asList("Consultas SQL", "Joins", "Índices", "Transacciones", "Stored Procedures"),
                        Arrays.asList("Conocimientos básicos de SQL"),
                        Arrays.asList("SQL", "Database", "PostgreSQL")),
                createCourse("Ciberseguridad y Hacking Ético", "Protege aplicaciones web", "Seguridad", "Avanzado",
                        4.9, "65 horas", 5430, 195, 0, "Pentesting Web", "cybersecurity.jpg", "$89.99", "$149.99", 950, true, false, Course.CourseStatus.NOT_STARTED,
                        Arrays.asList("Pentesting", "OWASP Top 10", "Kali Linux", "Metasploit"),
                        Arrays.asList("Redes, Linux, programación básica"),
                        Arrays.asList("Security", "Hacking", "Pentesting"))
        );
        courses.forEach(courseService::save);
    }

    private Course createCourse(String title, String desc, String cat, String level, Double rating,
            String duration, Integer students, Integer lessons, Integer completedLessons,
            String nextLesson, String thumbnail, String price, String originalPrice,
            Integer xp, Boolean isNew, Boolean isTrending, Course.CourseStatus status,
            List<String> learningPoints, List<String> requirements, List<String> tags) {
        Course c = new Course();
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
        s.setLevel(level);
        s.setTarget(target);
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
}
