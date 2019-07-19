package service;

import Repository.EmpRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.x.protobuf.Mysqlx;
import models.Person;
import models.Vehicle;
import play.libs.Json;
import play.mvc.Result;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import static play.mvc.Results.ok;

public class empservice implements EmpServiceInterface {



    @Inject
    EmpRepo empRepo;
    static final ObjectMapper objectMapper;

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

        objectMapper = new ObjectMapper();
    }

    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Vehicle vehicle) {


        empRepo.save(vehicle, entityManager);
    }

    @Override
    public JsonNode savePerson(JsonNode jsonNode) throws Exception {

        ObjectNode node = Json.newObject();

        JsonNode jsonNode1;
        try {
            String personName = jsonNode.path("person").get("name").asText();
            Person person = new Person(personName);
            entityManager.getTransaction().begin();
            empRepo.savePerson(person, entityManager);


            Iterator it = jsonNode.get("vehicle").iterator();

            String name;


            while (it.hasNext()) {
                JsonNode node1 = (JsonNode) it.next();
                System.out.println(node1.get("name").asText());
                name = node1.get("name").asText();
                Vehicle vehicle = new Vehicle(name, person);
                save(vehicle);
                System.out.println("Saved data ");


            }
            entityManager.getTransaction().commit();
            System.out.println("Persist done");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            node.put("status","Persist Failed");
            System.out.println("Null pointer exception rolled back ");
            jsonNode1 = (JsonNode) new ObjectMapper().readTree(node.toString());
            return jsonNode1;
            //return "error";
        }
        node.put("status","ok");
        jsonNode1 = (JsonNode) new ObjectMapper().readTree(node.toString());

        return jsonNode1;

    }


    @Override
    public JsonNode showPerson(Long id) throws Exception {

        ObjectNode node = Json.newObject();

        Person person = empRepo.showPerson(id, entityManager);
        String name = person.getName();

        node.put("Person Name",name);
        node.put("Person ID",id);

        Long id1 = person.getId();
        objectMapper.valueToTree(person);
        List<Vehicle> vehicleList = person.getVehicleList();
        for (int i = 0; i < vehicleList.size(); i++) {
            node.put("Vehicle Name",vehicleList.get(i).getName());


            objectMapper.valueToTree(vehicleList.get(i));
        }
        JsonNode jsonNode1 = (JsonNode) new ObjectMapper().readTree(node.toString());

        return jsonNode1;

    }


    @Override
    public JsonNode deletePerson(Long id) throws Exception{

        ObjectNode node = Json.newObject();

        try {
            Person person = empRepo.showPerson(id, entityManager);

            List<Vehicle> vehicleList = person.getVehicleList();
            Long id1;
            for (int i = 0; i < vehicleList.size(); i++) {
                id1 = vehicleList.get(i).getId();
                empRepo.deleteVehicle(id1, entityManager);
            }
            empRepo.deletePerson(id, entityManager);
            node.put("Status","Deleted");
            JsonNode jsonNode1 = (JsonNode) new ObjectMapper().readTree(node.toString());
            return jsonNode1;

        } catch (Exception e)
        {
           node.put("Status", e.getMessage());
            JsonNode jsonNode1 = (JsonNode) new ObjectMapper().readTree(node.toString());
            return jsonNode1;
        }

        //return empRepo.deletePerson(id, entityManager);
    }

    public void deleteVehicle(Long id) {
        empRepo.deleteVehicle(id, entityManager);
    }
}
