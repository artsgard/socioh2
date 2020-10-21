package com.artsgard.socioh2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SocioH2Repository extends JpaRepository<SocioModel, Long> {

    SocioModel findByUsername(String username);
    SocioModel findByEmail(String email);
    SocioModel findByFirstName(String name);
}
