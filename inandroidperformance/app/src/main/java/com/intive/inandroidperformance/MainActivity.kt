package com.intive.inandroidperformance

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.intive.inandroidperformance.internal.ProviderType
import com.intive.inandroidperformance.internal.fibonacci.FibonacciDataProviderFactory
import com.intive.inandroidperformance.internal.list.ListAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        private const val MAIN_SCREEN_COMPLEXITY_STEP = 1
    }

    private val fibonacciDataProviderFactory = FibonacciDataProviderFactory({ complexity })
    private lateinit var recyclerView: RecyclerView
    private lateinit var providerSwitch: SwitchCompat
    private var complexity: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupComplexityButtons()
        setupLinearLayoutScreenButton()
        setupConstraintLayoutScreenButton()
        setupDataProviderSwitch()
        setupRecyclerView()
    }

    private fun setupComplexityButtons() {
        val complexityLabel = findViewById<TextView>(R.id.complexity_value)

        findViewById<Button>(R.id.complexity_decrease).setOnClickListener {
            decreaseComplexityIfPossible()
            refreshComplexityLabel(complexityLabel)
        }

        findViewById<Button>(R.id.complexity_increase).setOnClickListener {
            increaseComplexity()
            refreshComplexityLabel(complexityLabel)
        }
    }

    private fun decreaseComplexityIfPossible() {
        if (complexity > 0) {
            complexity -= MAIN_SCREEN_COMPLEXITY_STEP
        }
    }

    private fun refreshComplexityLabel(complexityLabel: TextView) {
        complexityLabel.text = "$complexity"
    }

    private fun increaseComplexity() {
        complexity += MAIN_SCREEN_COMPLEXITY_STEP
    }

    private fun setupLinearLayoutScreenButton() {
        findViewById<View>(R.id.ll_button).setOnClickListener {
            navigateToLinearLayoutScreen()
        }
    }

    private fun navigateToLinearLayoutScreen() {
        val intent = Intent(this, LinearLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun setupConstraintLayoutScreenButton() {
        findViewById<View>(R.id.cl_button).setOnClickListener {
            navigateToConstraintLayoutScreen()
        }
    }

    private fun navigateToConstraintLayoutScreen() {
        val intent = Intent(this, ConstraintLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = createListAdapter(providerSwitch.isChecked)
        }
    }

    private fun createListAdapter(isBetterImplementationRequested: Boolean): ListAdapter {
        val dataProvider = if (isBetterImplementationRequested) {
            fibonacciDataProviderFactory.create(ProviderType.BETTER)
        } else {
            fibonacciDataProviderFactory.create(ProviderType.BAD)
        }
        return ListAdapter(dataProvider)
    }

    private fun setupDataProviderSwitch() {
        providerSwitch = findViewById<SwitchCompat>(R.id.provider_type_switch)
            .apply {
                setOnCheckedChangeListener { _, isChecked ->
                    recyclerView.adapter = createListAdapter(isChecked)
                }
            }
    }
}