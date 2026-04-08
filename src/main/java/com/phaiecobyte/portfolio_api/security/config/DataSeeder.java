package com.phaiecobyte.portfolio_api.security.config;

import com.phaiecobyte.portfolio_api.security.model.TCorePerm;
import com.phaiecobyte.portfolio_api.security.model.TCoreRole;
import com.phaiecobyte.portfolio_api.security.model.TCoreUsr;
import com.phaiecobyte.portfolio_api.security.repository.PermissionRepository;
import com.phaiecobyte.portfolio_api.security.repository.RoleRepository;
import com.phaiecobyte.portfolio_api.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        TCorePerm readAllPerm = createPermissionIfNotFound("READ_ALL");
        TCorePerm writeAllPerm = createPermissionIfNotFound("WRITE_ALL");

        TCoreRole adminRole = roleRepository.findByName("ADMIN").orElseGet(() -> {
            TCoreRole newRole = new TCoreRole();
            newRole.setName("ADMIN");
            // Add the seeded permissions to the admin role
            newRole.setPermissions(Set.of(readAllPerm, writeAllPerm));
            return roleRepository.save(newRole);
        });

        roleRepository.findByName("USER").orElseGet(() -> {
            TCoreRole newRole = new TCoreRole();
            newRole.setName("USER");
            // You can optionally assign default permissions to the basic user here
            return roleRepository.save(newRole);
        });

        // 3. Seed Admin User
        if (userRepository.findByUsername("phaiecobyte").isEmpty()) {
            TCoreUsr adminUser = new TCoreUsr();
            adminUser.setUsername("phaiecobyte");

            // IMPORTANT: Encode the password before saving!
            adminUser.setPassword(passwordEncoder.encode("phaiecobyte123"));

            // Assign the ADMIN role
            adminUser.setRoles(Set.of(adminRole));

            userRepository.save(adminUser);
            System.out.println("✅ Default Admin User seeded successfully! (Username: admin, Password: admin123)");
        } else {
            System.out.println("ℹ️ Admin user already exists. Skipping seeding.");
        }


    }

    private TCorePerm createPermissionIfNotFound(String name) {
        return permissionRepository.findByName(name).orElseGet(() -> {
            TCorePerm newPerm = new TCorePerm();
            newPerm.setName(name);
            return permissionRepository.save(newPerm);
        });
    }
}
