package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;

@ImplementedBy(empservice.class)
public interface EmpServiceInterface {
    public JsonNode savePerson(JsonNode jsonNode) throws Exception;

    public JsonNode showPerson(Long id) throws Exception ;

    public JsonNode deletePerson(Long id) throws Exception;




    }
