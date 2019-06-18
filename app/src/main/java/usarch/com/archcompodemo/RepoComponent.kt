package usarch.com.archcompodemo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UtilityModule::class))
interface RepoComponent {

     fun getRepo() : Repo;
}