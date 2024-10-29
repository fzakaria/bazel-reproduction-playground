public class Sealed {

    public sealed interface Error {

        record UserNotFound(String userName) implements Error {
        }

        record OtherError(Throwable cause) implements Error {
        }
    }

    public static void handleError(Error error) {
        switch (error) {
            case Error.UserNotFound userNotFound ->
                    System.out.println("User not found: " + userNotFound.userName());

            case Error.OtherError otherError ->
                    System.out.println("An error occurred: " + otherError.cause().getMessage());
        }
    }


    enum Direction {
        NORTH, SOUTH, EAST, WEST;
    }

    public static int Bearing(Direction d) {
        return switch (d) {                          // (1)
            case NORTH -> 0;                            // (2), (3)
            case SOUTH -> 180;
            case EAST -> 90;
            case WEST -> {
                System.out.println("Go west!");
                yield 270;                              // (4)
            }
        };
    }

}