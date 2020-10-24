package com.artsgard.socioh2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioH2Repository extends JpaRepository<SocioModel, Long> {

    SocioModel findByUsername(String username);
    SocioModel findByEmail(String email);
    SocioModel findByLastName(String name);
    SocioModel findByFirstName(String nm);
}
