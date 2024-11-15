package courtBookingSystemFinal.dto;
import lombok.*;
import courtBookingSystemFinal.model.User;

// This class was created for purpose that log messages(errors) are being sent back to Postman as HTTP response
// Error messages are being handled in class GlobalExceptionHandler
@Data


public class UserResponseDTO extends User {

    private String message;
    private User user;

    public UserResponseDTO(String message, User user) {
        this.message = message;
        this.user = user;
    }
}
