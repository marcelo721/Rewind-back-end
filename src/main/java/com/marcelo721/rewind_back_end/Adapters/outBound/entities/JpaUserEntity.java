package com.marcelo721.rewind_back_end.Adapters.outBound.entities;


import com.marcelo721.rewind_back_end.domain.model.entities.User;
import com.marcelo721.rewind_back_end.domain.model.enums.StatusAccount;
import com.marcelo721.rewind_back_end.domain.model.enums.UserType;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class JpaUserEntity extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;


    @Column(name = "nick_name", nullable = false, length = 21)
    private String nickName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "description",nullable = false, length = 100)
    private String description;

    @Column(name = "role_user", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "status_account", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusAccount statusAccount;


    public JpaUserEntity(UUID id, String nickName, String email, String password,
                         String description, UserType userType, StatusAccount statusAccount) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.description = description;
        this.userType = userType;
        this.statusAccount = statusAccount;
    }

    public JpaUserEntity(User user){
        this.id = user.getID();
        this.statusAccount =  user.getStatusAccount();
        this.userType = user.getUserType();
        this.nickName = user.getNickName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.description = user.getDescription();
    }

    public JpaUserEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusAccount getStatusAccount() {
        return statusAccount;
    }

    public void setStatusAccount(StatusAccount statusAccount) {
        this.statusAccount = statusAccount;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
