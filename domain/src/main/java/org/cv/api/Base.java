package org.cv.api;

import com.onezero.base.Creatable;
import com.onezero.base.IBase;
import com.onezero.base.Modifiable;
import lombok.Data;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.Column;
import org.beetl.sql.annotation.entity.InsertIgnore;
import org.beetl.sql.annotation.entity.UpdateIgnore;

import java.time.LocalDateTime;
@Data
public class Base  implements IBase<Long>, Creatable<Long, LocalDateTime>, Modifiable<Long, LocalDateTime> {
    @AutoID
    private Long id;

    @Auto
    @UpdateIgnore
    private Long creator;

    @Auto
    @UpdateIgnore
    private LocalDateTime created;

    @Auto
    @InsertIgnore
    private Long modifier;

    @Auto
    @InsertIgnore
    private LocalDateTime modified;

    @Auto
    @Column("creator_name")
    @UpdateIgnore
    private String creatorName;

    @Auto
    @Column("modifier_name")
    @InsertIgnore
    private String modifierName;
}
