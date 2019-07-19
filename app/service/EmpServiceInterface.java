package service;

import com.fasterxml.jackson.databind.JsonNode;

public interface EmpServiceInterface {
    public JsonNode savePerson(JsonNode jsonNode) throws Exception;

    public JsonNode showPerson(Long id) throws Exception ;

    public JsonNode deletePerson(Long id) throws Exception;




    }
