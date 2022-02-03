package application.services.db;

import application.data.money.amount.AmountOfMoney;
import application.data.money.amount.AmountOfMoneyInterface;
import application.data.user.UserData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DBController {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static List<AmountOfMoney> accounts;

    // @TODO indices assignment, reading from file

    public static void dumpDatabaseState(List<AmountOfMoney> accounts) {
        try{
            PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                    .allowIfBaseType("application.data.money.amount")
                    .build();
            objectMapper.activateDefaultTyping(ptv);
            objectMapper.writer(new DefaultPrettyPrinter()).writeValue(new File("db/accounts.json"), accounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<AmountOfMoney> importDataBaseState() throws IOException {
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType("application.data.money.amount")
                .build();
        objectMapper.activateDefaultTyping(ptv);
        return Arrays.asList(objectMapper.reader().readValue(new File("db/accounts.json"), AmountOfMoney[].class));
    }

    public static boolean checkDataBaseExistence() {
        File database = new File("db/accounts.json");
        return database.exists() && database.isFile();
    }
}
