package com.SpringBoot.Attendance_Backend.Entity;
import com.SpringBoot.Attendance_Backend.Enums.Category;
import com.SpringBoot.Attendance_Backend.Enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MemberId;
    @NotBlank
    private String MemberName;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotBlank
    private String email;
    @NotBlank
    private String Phone;

    public Long getMemberId() {
        return MemberId;
    }

    public void setMemberId(Long memberId) {
        MemberId = memberId;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
