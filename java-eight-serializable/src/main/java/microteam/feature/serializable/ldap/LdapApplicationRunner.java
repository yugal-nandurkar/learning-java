package microteam.feature.serializable.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LdapApplicationRunner implements CommandLineRunner {

    @Autowired
    private LdapService ldapService;

    @Override
    public void run(String... args) {
        String dn = "cn=Flower,dc=example,dc=com";
        String codebase = "http://web1/example/classes/";
        Flower flower = new Flower("rose", "pink");

        ldapService.bindSerializedFlower(dn, flower, codebase);

        System.out.println("Flower object bound to LDAP with codebase: " + codebase);
    }
}

