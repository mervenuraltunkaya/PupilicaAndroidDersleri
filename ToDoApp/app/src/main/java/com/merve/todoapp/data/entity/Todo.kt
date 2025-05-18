package com.merve.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class Todo (@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "hedef_id") @NotNull var hedef_id: Int,
                 @ColumnInfo(name = "hedef_name") @NotNull var hedef_ad:String) :Serializable {
}