package jonty.com.mojocar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by bharatkc on 11/8/14.
 */
public class Utility {
    public static StringBuilder inputStreamToString(InputStream is) {
        String line = "";
        StringBuilder output = new StringBuilder();
        // Wrap a BufferedReader around the InputStream
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        // Read response until the end
        try {
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return full string
        return output;
    }
}
