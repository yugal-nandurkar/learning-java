package microteam.feature.serializable;

import org.springframework.stereotype.Service;

@Service
public class SerializationService {

    private static final String PERSON_FILE = "person.ser";
    private static final String ORGANIZATION_FILE = "organization.ser";
    private static final String SYMBOL_FILE = "symbol.ser";

    public void demonstrateStreamElements() {
        // Serialize and deserialize a Person object
        Person person = new Person("Alice", 30);
        SerializationUtil.serialize(person, PERSON_FILE);
        Person deserializedPerson = SerializationUtil.deserialize(PERSON_FILE.getBytes());
        System.out.println("Serialized and deserialized Person: " + deserializedPerson);

        // Serialize and deserialize an Organization with an array
        Person[] members = {new Person("Bob", 25), new Person("Charlie", 35)};
        Organization org = new Organization("Tech Corp", members);
        SerializationUtil.serialize(org, ORGANIZATION_FILE);
        Organization deserializedOrg = SerializationUtil.deserialize(ORGANIZATION_FILE.getBytes());
        System.out.println("Serialized and deserialized Organization: " + deserializedOrg);

        // Serialize and deserialize an Enum
        Role role = Role.ADMIN;
        String roleFile = "role.ser";
        SerializationUtil.serialize(role, roleFile);
        Role deserializedRole = SerializationUtil.deserialize(roleFile.getBytes());
        System.out.println("Serialized and deserialized Role: " + deserializedRole);
    }

    public void demonstrateWriteReplace() {
        // Original object
        Person person = new Person("Alice", 30);

        System.out.println("Before Serialization: " + person);

        // Serialize the object
        byte[] serializedData = SerializationUtil.serialize(person, PERSON_FILE);

        // Deserialize the object
        Object deserializedObject = SerializationUtil.deserialize(serializedData);

        System.out.println("After Deserialization: " + deserializedObject);
    }

    public void demonstrateReadResolve() {
        // Serialize and deserialize a Symbol object
        Symbol symbol1 = Symbol.getInstance("Alpha");
        System.out.println("Original Symbol: " + symbol1);

        SerializationUtil.serialize(symbol1, SYMBOL_FILE);
        Symbol deserializedSymbol = SerializationUtil.deserialize(SYMBOL_FILE.getBytes());
        System.out.println("Deserialized Symbol: " + deserializedSymbol);

        // Verify that the original and deserialized symbols are the same instance
        System.out.println("Are the instances identical? " + (symbol1 == deserializedSymbol));
    }
}

