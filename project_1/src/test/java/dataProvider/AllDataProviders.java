package dataProvider;

import annotation.Source;
import model.User;
import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AllDataProviders {

    private static final Logger LOGGER = Logger.getLogger(AllDataProviders.class);
    private static final String DATA_FOLDER = "src/test/resources/data/";

    @DataProvider
    public static Iterator<Object[]> validUsers(Method method) throws IOException {
        List<User> users = new ArrayList<>();
        if (method.isAnnotationPresent(Source.class)) {
            Source annotation = method.getAnnotation(Source.class);
            BufferedReader buffReader = new BufferedReader(new FileReader(new File(DATA_FOLDER + annotation.value())));
            String line = buffReader.readLine();
            switch (annotation.type()) {
                case CSV:
                    while (line != null) {
                        String[] splitLine = line.split(";");
                        users.add(new User().setLogin(splitLine[0])
                                            .setPassword(splitLine[1]));
                        line = buffReader.readLine();
                        LOGGER.info("Data is successfully retrieved from CSV-file");
                    }
                    break;
                case XML:

                    break;
                case JSON:

                    break;
                case EXCEL:

                    break;
            }
            buffReader.close();
        } else {
            LOGGER.warn("'" + method.getName() + "' hasn't @DataProvider annotation!");
        }
        return users.stream().map(i -> new Object[]{i}).collect(Collectors.toList()).iterator();
    }
}
