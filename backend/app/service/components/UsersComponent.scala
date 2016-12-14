package service.components

import models.User
import play.api.db.slick.HasDatabaseConfigProvider
import slick.driver.JdbcProfile

/**
  * Created by gregory on 04.12.16.
  */

trait UsersComponent {
  this: HasDatabaseConfigProvider[JdbcProfile] =>

  import driver.api._

  class Users(tag: Tag) extends Table[User](tag, "users") {
    def * = (id, name) <> (User.tupled, User.unapply)
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
  }

}