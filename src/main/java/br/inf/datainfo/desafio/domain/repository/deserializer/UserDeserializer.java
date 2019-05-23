package br.inf.datainfo.desafio.domain.repository.deserializer;

import br.inf.datainfo.desafio.domain.entity.User;
import br.inf.datainfo.desafio.domain.repository.ExternalUserFunctionRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class UserDeserializer extends JsonDeserializer {
    @Autowired
    ExternalUserFunctionRepository externalUserFunctionRepository;

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        User user = new User();

        String icSituation = node.get("icSituation") == null ? "A" : node.get("icSituation").textValue();

        user.setNuCpf(node.get("nuCpf").textValue());
        user.setNoUser(node.get("noUser").textValue());
        user.setDeEmail(node.get("deEmail").textValue());
        user.setIcSituation(icSituation);
        user.setIcUserProfile(node.get("icUserProfile").intValue());
        user.setNuPhone(node.get("nuPhone").textValue());

        Long coFunction = node.get("coFunction").longValue();
        user.setExternalUserFunction(externalUserFunctionRepository.findByCoFunction(coFunction));

        return user;
    }
}
