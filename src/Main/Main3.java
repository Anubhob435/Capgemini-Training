package src.Main;

import java.util.*;

class SecurityException extends Exception {
    private String message;
    private String errorCode;
    static final long serialVersionUID = 1L;

    public SecurityException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}

class SecureChannel {
    private String channelId;
    private String userId;
    private String userEncryptionToken;
    private int channelEncryptionKeyLength;

    public SecureChannel(String channelId, String userId) {
        this.channelId = channelId;
        this.userId = userId;
        this.userEncryptionToken = null;
        this.channelEncryptionKeyLength = 0;
    }

    public SecureChannel(String channelId, String userId, String userEncryptionToken) {
        this.channelId = channelId;
        this.userId = userId;
        this.userEncryptionToken = userEncryptionToken;
        this.channelEncryptionKeyLength = 0;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserEncryptionToken() {
        return userEncryptionToken;
    }

    public int getChannelEncryptionKeyLength() {
        return channelEncryptionKeyLength;
    }

    public void setChannelEncryptionKeyLength(int length) {
        this.channelEncryptionKeyLength = length;
    }
}

class SecureTransmission {

    public static void sendMessage(SecureChannel channel, int messageLength)
            throws SecurityException {

        if (channel.getUserEncryptionToken() == null) {
            throw new SecurityException("User not authorized", "USER_NOT_AUTHORIZED");
        }

        if (messageLength <= 0) {
            throw new SecurityException("Invalid message length", "INVALID_MESSAGE_LENGTH");
        }

        int newLength = channel.getChannelEncryptionKeyLength() + messageLength;
        channel.setChannelEncryptionKeyLength(newLength);
    }

    public static void readMessage(SecureChannel channel, int messageLength)
            throws SecurityException {

        if (messageLength <= 0) {
            throw new SecurityException("Invalid message length", "INVALID_MESSAGE_LENGTH");
        }

        if (channel.getChannelEncryptionKeyLength() < messageLength) {
            throw new SecurityException("Insufficient decryption key", "INSUFFICIENT_DECRYPTION_KEY");
        }

        int newLength = channel.getChannelEncryptionKeyLength() - messageLength;
        channel.setChannelEncryptionKeyLength(newLength);
    }
}

public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, SecureChannel> channels = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts.length == 3) {
                channels.put(parts[0],
                        new SecureChannel(parts[0], parts[1], parts[2]));
            } else {
                channels.put(parts[0],
                        new SecureChannel(parts[0], parts[1]));
            }
        }

        int q = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < q; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String channelId = parts[0];
            String operation = parts[1];
            int messageLength = Integer.parseInt(parts[2]);

            SecureChannel channel = channels.get(channelId);

            try {

                if (operation.equals("send")) {
                    SecureTransmission.sendMessage(channel, messageLength);
                } else if (operation.equals("read")) {
                    SecureTransmission.readMessage(channel, messageLength);
                }

            } catch (SecurityException e) {
                System.out.println(e.getErrorCode());
            }
        }

        for (SecureChannel c : channels.values()) {
            System.out.println(
                    c.getChannelId() + " " +
                    c.getUserId() + " " +
                    c.getChannelEncryptionKeyLength()
            );
        }

        sc.close();
    }
}