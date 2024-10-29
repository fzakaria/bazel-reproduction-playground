public class Test {

    public static int test(Sealed.Direction d) {
        return Sealed.Bearing(d);
    }

    public static void handleError(Sealed.Error error) {
        switch (error) {
            case Sealed.Error.UserNotFound userNotFound ->
                    System.out.println("User not found: " + userNotFound.userName());

            case Sealed.Error.OtherError otherError ->
                    System.out.println("An error occurred: " + otherError.cause().getMessage());
        }
    }

    public static int Bearing(Sealed.Direction d) {
        return switch (d) {
            case NORTH -> 0;
            case SOUTH -> 180;
            case EAST -> 90;
            case WEST -> {
                System.out.println("Go west!");
                yield 270;
            }
        };
    }

}