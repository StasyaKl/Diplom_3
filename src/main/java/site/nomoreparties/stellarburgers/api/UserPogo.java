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

    public String setPassword(String password) {
        return this.password = password;
    }

    public static UserPogo create(){
        return new UserPogo(
                RandomStringUtils.randomAlphabetic(10) + "@ya.ru",
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10)
        );
    }
}