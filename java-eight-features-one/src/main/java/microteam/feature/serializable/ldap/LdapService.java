package microteam.feature.serializable.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Service
public class LdapService {

    @Autowired
    private LdapTemplate ldapTemplate;

    public void bindSerializedFlower(String dn, Flower flower, String codebase) {
        try {
            // Serialize the object
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(flower);
            oos.close();

            // Prepare LDAP attributes
            BasicAttributes attributes = new BasicAttributes();
            BasicAttribute objClassAttr = new BasicAttribute("objectClass", "javaSerializedObject");
            BasicAttribute serializedAttr = new BasicAttribute("javaSerializedData", baos.toByteArray());
            BasicAttribute codebaseAttr = new BasicAttribute("javaCodebase", codebase);

            attributes.put(objClassAttr);
            attributes.put(serializedAttr);
            attributes.put(codebaseAttr);

            // Perform the binding
            ldapTemplate.bind(LdapUtils.newLdapName(dn), null, attributes);
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize the object", e);
        }
    }
}

