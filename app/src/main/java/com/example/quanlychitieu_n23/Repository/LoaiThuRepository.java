package com.example.quanlychitieu_n23.Repository;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quanlychitieu_n23.Dao.AppDatabase;
import com.example.quanlychitieu_n23.Dao.LoaiThuDao;
import com.example.quanlychitieu_n23.Entity.LoaiThu;

import java.util.List;


public class LoaiThuRepository {
    private LoaiThuDao mLoaiThuDao;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThuRepository(Application application) {
        this.mLoaiThuDao = AppDatabase.getDatabase(application).loaiThuDao();
        mAllLoaiThu=mLoaiThuDao.findall();
    }
    public LiveData<List<LoaiThu>> getmAllLoaiThu()
    {
        return mAllLoaiThu;
    }
    public void insert(LoaiThu loaiThu){
        new InsertAsyncTask(mLoaiThuDao).execute();
    }
    class InsertAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDao mLoaiThuDao;
        public InsertAsyncTask(LoaiThuDao loaiThuDao)
        {
            this.mLoaiThuDao= loaiThuDao;
        }
        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
}
