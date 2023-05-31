import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.local.entity.NoteDescriptionEntity
import com.example.todolist_.onboarding.domain.NoteDataClass
import com.example.todolist_.onboarding.domain.NoteDescriptionDataClass
import com.example.todolist_.onboarding.domain.repository.IOnboardingRepository
import com.example.todolist_.onboarding.domain.use_case.GetNoteDescriptionList
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@ViewModelScoped
class GetAddNoteList @Inject constructor(
    private val onBoardingRepository: IOnboardingRepository
) {
    suspend operator fun invoke()= onBoardingRepository.getNoteListFromDB()
 /* val isNoteSaved=onboardingRepository.saveNote().first()
         return isNoteSaved
             onboardingRepository.getNoteListFromDB()
         }*/
    }

        /*
        val isCitySaved = onboardingRepository.isAddNotesSaved().first()
        return if (isCitySaved) {
            onboardingRepository.getNoteDescriptionListFromDB()
        } else {
            val list = onboardingRepository.get()
            list.collectLatest {
                if (it is BaseResourceEvent.Success) {
                    it.data?.let { list ->
                        onboardingRepository.saveCity(list)
                    }
                    onboardingRepository.saveCityControl()
                }
            }
            list
        }
    }
}
/*  if (descriptions.isEmpty()) {
        LottieAnimation()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(descriptions) { item ->
                Text(text = item.description, modifier = Modifier.padding(8.dp))
            }
        }
    }*/