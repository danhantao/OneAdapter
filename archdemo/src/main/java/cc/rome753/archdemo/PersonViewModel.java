package cc.rome753.archdemo;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * Created by chao on 18-6-19.
 */

public class PersonViewModel extends ViewModel {

    private final LiveData<List<Person>> mPersonLiveData;

    private final MutableLiveData<String> mReloadLiveData;

    public PersonViewModel() {
        mReloadLiveData = new MutableLiveData<>();
        mPersonLiveData = Transformations.switchMap(mReloadLiveData, new Function<String, LiveData<List<Person>>>() {
            @Override
            public LiveData<List<Person>> apply(String input) {
                return DataRepository.getPersonLiveData();
            }
        });

    }

    public LiveData<List<Person>> getLiveData(){
        return mPersonLiveData;
    }

    public void reload(){
        mReloadLiveData.setValue("");
    }
}
