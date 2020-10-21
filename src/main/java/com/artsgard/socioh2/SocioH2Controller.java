package com.artsgard.socioh2;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/")
public class SocioH2Controller {

    private SocioH2Repository socioH2Repository;

    @Autowired
    public SocioH2Controller(
            SocioH2Repository socioH2Repository) {
        this.socioH2Repository = socioH2Repository;
    }

     org.slf4j.Logger logger = LoggerFactory.getLogger(SocioH2Controller.class);

    /**
     *
     * @return list of socios
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SocioModel>> findAllSocios() {
        return new ResponseEntity<>(socioH2Repository.findAll(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return single socio
     */
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<SocioModel> findSocioById(@PathVariable Long id) {
        SocioModel socio = socioH2Repository.getOne(id);
        if (socio != null) {
            return new ResponseEntity<>(socio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param username
     * @return single socio
     */
    @GetMapping(path = "/username/{username}", produces = "application/json")
    public ResponseEntity<SocioModel> findSocioByUsername(@PathVariable String username) {
        SocioModel socio = socioH2Repository.findByUsername(username);
        if (socio != null) {
            return new ResponseEntity<>(socio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(path = "/email/{email}", produces = "application/json")
    public ResponseEntity<SocioModel> findSocioByEmail(@PathVariable String email) {
        SocioModel socio = socioH2Repository.findByEmail(email);
        if (socio != null) {
            return new ResponseEntity<>(socio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     *
     * @param socioDTO
     * @return status created/ save socio
     */
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<SocioModel> saveSocio(@Valid @RequestBody SocioModel socioModel) {
        socioModel.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        SocioModel socio = socioH2Repository.save(socioModel);
        return new ResponseEntity<>(socio, HttpStatus.CREATED);
    }

    /**
     *
     * @param socioDTO
     * @param id
     * @return status created/ update socio
     */
    @PutMapping(path = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SocioModel> updateSocio(@Valid @RequestBody SocioModel socioModel, @PathVariable Long id) {
        SocioModel socioDB = socioH2Repository.getOne(id);
        socioModel.setId(id);
        socioModel.setRegisterDate(socioDB.getRegisterDate());
        SocioModel socio = socioH2Repository.save(socioModel);
        if (socio != null) {
            return new ResponseEntity<>(socio, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param id delete single socio
     * @return status
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<SocioModel> deleteSocioById(@PathVariable("id") Long id) {
        socioH2Repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
