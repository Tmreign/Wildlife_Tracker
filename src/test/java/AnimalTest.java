//import org.junit.*;
//import static org.junit.Assert.*;
//import org.sql2o.*;
//
//public class AnimalTest {
//    @Test
//    public void animal_instantiatesCorrectly_true() {
//        Animal testAnimal = new Animal("Jane",  "young", "healthy","2","Zone A");
//        assertEquals(true, testAnimal instanceof Animal);
//    }
//
//    @Test
//    public void getName_animalInstantiatesWithName_Jane() {
//        Animal testAnimal = new Animal("Jane",  "young", "healthy","2","Zone B");
//        assertEquals("Jane", testAnimal.getRangername());
//    }
//
//    @Test
//    public void getAge_animalInstantiatesWithAge_healthy() {
//        Animal testAnimal = new Animal("Jane",  "young", "healthy","2","Zone C");
//        assertEquals("2", testAnimal.getAge());
//    }
//
//    @Test
//    public void getHealth_animalInstantiatesWithHealth_young() {
//        Animal testAnimal = new Animal("Jane",  "young", "healthy","2","Zone D");
//        assertEquals("healthy", testAnimal.getHealth());
//    }
//
//    @Test
//    public void save_insertsObjectIntoDatabase_Animal() {
//        Animal testAnimal = new Animal("Jane", "young", "healthy", "2","Zone A");
//        testAnimal.save();
//        assertTrue(Animal.all().get(0).equals(testAnimal));
//    }
//
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void all_returnsAllInstancesOfAnimal_true() {
//        Animal firstAnimal = new Animal("Jane", "young", "healthy", "2","Zone B");
//        firstAnimal.save();
//        Animal secondAnimal = new Animal("Henry", "adult", "ill", "3","zone C");
//        secondAnimal.save();
//        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
//        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
//    }
//
//    @Test
//    public void save_assignsIdToObject() {
//        Animal testAnimal = new Animal("Jane", "young", "healthy", "2","Zone D");
//        testAnimal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(testAnimal.getId(), savedAnimal.getId());
//    }
//
//    @Test
//    public void find_returnsAnimalWithSameId_secondAnimal() {
//        Animal firstAnimal = new Animal("Jane",  "young", "healthy","2", "Zone A");
//        firstAnimal.save();
//        Animal secondAnimal = new Animal("Henry", "adult", "ill", "3","Zone A");
//        secondAnimal.save();
//        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
//        assertEquals(true,Animal.all().get(0).equals(firstAnimal));
////        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
//    }
//
//}