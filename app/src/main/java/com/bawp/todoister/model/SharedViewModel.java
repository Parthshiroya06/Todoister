package com.bawp.todoister.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Task> selectedItem=new MutableLiveData();
    private boolean isEdit;
    public void selectItem(Task task){
        selectedItem.setValue(task);

    }
    public LiveData<Task> getSelectItem(){
        return selectedItem;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
}
