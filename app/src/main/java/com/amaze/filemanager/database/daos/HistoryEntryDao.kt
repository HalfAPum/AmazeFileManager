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

import androidx.room.*
import com.amaze.filemanager.database.UtilitiesDatabase
import com.amaze.filemanager.database.models.utilities.History
import io.reactivex.Completable
import io.reactivex.Single

/**
 * [Dao] interface definition for [History]. Concrete class is generated by Room during
 * build.
 *
 * @see Dao
 *
 * @see History
 *
 * @see com.amaze.filemanager.database.UtilitiesDatabase
 */
@Dao
interface HistoryEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(instance: History): Completable

    @Update
    fun update(instance: History): Completable

    @Query("SELECT * FROM " + UtilitiesDatabase.TABLE_HISTORY)
    fun list(): Single<List<History>>

    @Query(
        "DELETE FROM " +
            UtilitiesDatabase.TABLE_HISTORY +
            " WHERE " +
            UtilitiesDatabase.COLUMN_PATH +
            " = :path"
    )
    fun deleteByPath(path: String): Completable

    @Query("DELETE FROM " + UtilitiesDatabase.TABLE_HISTORY)
    fun clear(): Completable
}
