package site.nomoreparties.stellarburgers.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserPogo {
    private String email;
    private String password;
    private String name;

    public static UserPogo create(){
        return new UserPogo(
                RandomStringUtils.randomAlphabetic(6) + "@mail.com",
                RandomStringUtils.randomAlphabetic(6),
                RandomStringUtils.randomAlphabetic(6)
        );
    }
}
