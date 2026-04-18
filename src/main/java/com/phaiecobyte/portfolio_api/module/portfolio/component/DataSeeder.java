//package com.phaiecobyte.portfolio_api.module.portfolio.component;
//
//
//import com.phaiecobyte.portfolio_api.module.portfolio.model.*;
//import com.phaiecobyte.portfolio_api.module.portfolio.repository.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class DataSeeder implements CommandLineRunner {
//    private final SkillRepository skillRepository;
//    private final EducationRepository educationRepository;
//    private final ExperienceRepository experienceRepository;
//    private final LanguageRepository languageRepository;
//    private final ProjectRepository projectRepository;
//    private final ReferenceRepository referenceRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if(skillRepository.count() == 0){
//            seedSkill();
//        }
//        if(educationRepository.count() == 0){
//            seedEdu();
//        }
//        if(experienceRepository.count() == 0){
//            seedExperience();
//        }
//        if(languageRepository.count() == 0){
//            seedLang();
//        }
//        if(projectRepository.count() == 0){
//            seedProject();
//        }
//        if(referenceRepository.count() == 0){
//            seedRef();
//        }
//    }
//
//    void seedSkill(){
//        skillRepository.save(new Skill("Spring Boot",75,"fa-brands fa-java"));
//        skillRepository.save(new Skill(".Net Framework",50,"fa-solid fa-code"));
//    }
//    void seedEdu(){
//        educationRepository.save(new Education("Bachelor","Information of Technology","Build Bright University","2022","2025", "Phnom Penh"));
//    }
//    void seedExperience(){
//        String desc = "Develope, fix bugs and improve java applications .Research new technologies and improve performance and security of existing systems.";
//        experienceRepository.save(new Experience("Java Developer","2025","Now",desc));
//    }
//
//    void seedLang(){
//        languageRepository.save(new Language("Khmer",100,"fi fi-kh"));
//        languageRepository.save(new Language("English",50,"fi fi-sh"));
//    }
//
//    void seedProject(){
//        List<String> tech = new ArrayList<>();
//        tech.add("Java 21");
//        tech.add("Spring boot");
//        tech.add("postgres");
//        tech.add("Angular 21");
//
//        List<String> feature = new ArrayList<>();
//        feature.add("Dynamic Content");
//        feature.add("Telegram bot integration");
//
//        projectRepository.save(new Project("Portfolio",tech,"null","null",feature,null));
//    }
//
//    void seedRef(){
//        referenceRepository.save(new Reference("Angkor","Dean of Faculty of Science and Technology","Phnom Penh","ankor@contact.com","023444555"));
//    }
//}
