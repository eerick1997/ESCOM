package Protocol.Automaton;

import Files.MyFile;
import java.io.FileReader;
import java.util.ArrayList;

public class Protocol {

    private static final String Start = "start", Ready = "ready", Sending = "sending";
    private static final String path_protocol_history = "protocol/protocol_history.txt";

    private MyFile historyProtocol;

    private ArrayList<String> packages;

    private Ack ack;

    public Protocol() {
        historyProtocol = new MyFile(path_protocol_history);
        ack = new Ack();
    }

    public void readByKeyboard(String str) {
        divideMessage(str);
        for (int i = 0; i < packages.size(); i++) {
            if (sendToStates(packages.get(i)) == 0) {
                i--;
            }
        }
        ack.getWords().closeFile();
        ack.getHistory().closeFile();
    }

    public void readByFile(String path) {
        String contentFile = "";
        try {
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();
            while (character != -1) {
                character = fileReader.read();
                contentFile += (char) character;
            }
            character = fileReader.read(); // If i delete this line 
            contentFile += (char) character;
            //This program can't read the last character

            fileReader.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        //Here isn't necessary create other function
        //readByKeyboard divide the message of the file.
        readByKeyboard(contentFile);
    }

    public void divideMessage(String str) {
        String package_protocol = "";

        packages = new ArrayList<>();

        if (str.length() >= 100) {

            for (int i = 0; i < str.length(); i++) {
                package_protocol += str.charAt(i);
                if (i % 99 == 0 && i != 0) {
                    System.out.println("package_protocol: " + package_protocol);
                    packages.add(package_protocol);
                    package_protocol = "";
                }
            }
            System.out.println("package_protocol: " + package_protocol);
            if (!package_protocol.isEmpty()) {
                packages.add(package_protocol);
            }

        } else {
            packages.add(str);
        }
    }

    public double sendToStates(String _package) {
        String actualState = Start;
        double isWorking = Math.rint(Math.random());
        if (isWorking == 1) {//Is working = true
            System.out.println("Protocol is on");
            historyProtocol.writeSth(actualState + "---" + 1 + "--->" + Ready);
            actualState = Ready;
            actualState = states(_package, actualState);

        } else {//Protocol isn't working
            historyProtocol.writeSth(actualState + "---" + 0 + "--->" + Start);
            System.out.println("Protocol is off");
        }
        return isWorking;
    }

    public String states(String string, String actualState) {
        String newState = "";

        if (actualState.equals(Ready)) {
            newState = Sending;
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.err.println("An excepcion has occurred: " + e);
            }
        }
        historyProtocol.writeSth(actualState + "------->" + newState);
        ack.searchAWord(string);
        return newState;
    }

    public MyFile getHistoryProtocol() {
        return historyProtocol;
    }
}
