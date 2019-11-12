package com.marveltravel.map.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.currency.CurrencyExchange;
import com.marveltravel.map.data.entity.currency.SpinnerAdapter;
import com.marveltravel.map.data.network.RetrofitBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.marveltravel.map.BuildConfig.CURRENCY_BASE_URL;
import static com.marveltravel.map.BuildConfig.CURRENCY_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment {
    private static final String TAG = "-TAG";
    @BindView(R.id.result_map)
    TextView result;
    @BindView(R.id.editText_map)
    EditText editText;
    @BindView(R.id.spinner2)
    Spinner spinner;
    @BindView(R.id.spinner)
    Spinner secondSpinner;
    @BindView(R.id.calculate)
    Button calculate;
    double valute;
    double secondValute;
    double resultMon;
    String myChoose;

    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getCurrency();
        getConverterCalc();
    }

    private void getCurrency() {
        RetrofitBuilder.getInstance().getCurrency(CURRENCY_BASE_URL, CURRENCY_KEY, "1").enqueue(new Callback<CurrencyExchange>() {
            @Override
            public void onResponse(Call<CurrencyExchange> call, Response<CurrencyExchange> response) {
                if (response.body() != null && response.isSuccessful()) {
                    CurrencyExchange data = response.body();
                    SpinnerAdapter adapter = new SpinnerAdapter(getContext(),
                            R.layout.item_currency, data.getCurrencyList());
                    spinner.setAdapter(adapter);
                    secondSpinner.setAdapter(adapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(getContext(), String.valueOf(response.body().getCurrencyList().get(i).getRate()), Toast.LENGTH_SHORT).show();
                            valute =response.body().getCurrencyList().get(i).getRate();
                            getConverterCalc();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                            Log.e(TAG, "onNothingSelected: " );

                        }
                    });
                    secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            secondValute = response.body().getCurrencyList().get(i).getRate();
                            getConverterCalc();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                            Log.e(TAG, "onNothingSelected: " );
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<CurrencyExchange> call, Throwable t) {
                Log.e(TAG, "onFailure: ");
            }
        });
    }
    private void getConverterCalc() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoose = editText.getText().toString();
                resultMon = (Double.parseDouble(myChoose) / valute) * secondValute;
                double output = resultMon;
                output = Math.round(output * 100.0) / 100.0;
                result.setText(String.valueOf(output));
            }
        });
    }
}
