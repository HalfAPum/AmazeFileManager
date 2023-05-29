/*
 * Copyright (C) 2014-2023 Arpit Khurana <arpitkh96@gmail.com>, Vishal Nehra <vishalmeham2@gmail.com>,
 * Emmanuel Messulam<emmanuelbendavid@gmail.com>, Raymond Lai <airwave209gt at gmail.com> and Contributors.
 *
 * This file is part of Amaze File Manager.
 *
 * Amaze File Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.amaze.filemanager.database.UtilitiesDatabase
import com.amaze.filemanager.database.models.utilities.Hidden
import io.reactivex.Completable
import io.reactivex.Single

/**
 * [Dao] interface definition for [Hidden]. Concrete class is generated by Room during
 * build.
 *
 * @see Dao
 *
 * @see Hidden
 *
 * @see com.amaze.filemanager.database.UtilitiesDatabase
 */
@Dao
interface HiddenEntryDao {

    @Insert
    fun insert(instance: Hidden): Completable

    @Update
    fun update(instance: Hidden): Completable

    @Query("SELECT " + UtilitiesDatabase.COLUMN_PATH + " FROM " + UtilitiesDatabase.TABLE_HIDDEN)
    fun listPaths(): Single<List<String>>

    @Query(
        "DELETE FROM " +
            UtilitiesDatabase.TABLE_HIDDEN +
            " WHERE " +
            UtilitiesDatabase.COLUMN_PATH +
            " = :path"
    )
    fun deleteByPath(path: String): Completable
}