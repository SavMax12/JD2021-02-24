package by.it._classwork_.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

class VarRepository {

    private static final String VARS_FILE_NAME =
            FileNameHelper.getFilePath("vars.txt", VarRepository.class);


    static void save(Map<String, Var> vars) throws CalcException {
        try (PrintWriter out = new PrintWriter(VARS_FILE_NAME)) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException("no save", e);
        }
    }

    static void load() {
        if (new File(VARS_FILE_NAME).exists())
            try {
                Parser parser = new Parser();
                Files.lines(Paths.get(VARS_FILE_NAME))
                        .forEach(line -> {
                            try {
                                parser.calc(line);
                            } catch (CalcException e) {
                                //stub
                            }
                        });
            } catch (IOException e) {
                //stub
            }
    }
}
