package gt.edu.umg.proyecto1.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "employee")
@SQLDelete(sql = "UPDATE management.employee SET is_active = 'false' WHERE id_employee = ?")
@SQLRestriction("is_active = true")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee", nullable = false, updatable = false, unique = true)
    private long idEmployee;

    @Column(name = "id_position", nullable = false)
    private long idPosition;

    @Column(name = "id_user", nullable = false, unique = true)
    private long idUser;

    @Column(name = "dpi", nullable = false, unique = true)
    private String dpi;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
