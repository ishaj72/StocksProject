package com.example.modules;


import com.example.enums.DocumentType;
import com.example.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "DOCUMENT_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "DOCUMENT_TYPE")
    private DocumentType documentType;

    @Column(name = "DOCUMENT_NAME")
    private String documentName;

    @Column(name = "DOCUMENT_URL")
    private String DocumentUrl;

    @Column(name = "VERIFICATION_STATUS")
    private VerificationStatus verificationStatus;

    @CreationTimestamp
    @Column(name = "UPLOAD_TIME", nullable = false, updatable = false)
    private LocalDateTime uploadTime;
}
