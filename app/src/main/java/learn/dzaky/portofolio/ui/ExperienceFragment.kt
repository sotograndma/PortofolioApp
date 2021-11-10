package learn.dzaky.portofolio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import learn.dzaky.portofolio.R
import learn.dzaky.portofolio.adapter.RVExperienceAdapter
import learn.dzaky.portofolio.data.Portofolio
import learn.dzaky.portofolio.data.PortofolioData.listDataExperience
import learn.dzaky.portofolio.databinding.FragmentExperienceBinding

class ExperienceFragment : Fragment() {

    private var _binding: FragmentExperienceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExperienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterExperience = RVExperienceAdapter()

        adapterExperience.onItemClicked = { experience ->
            findNavController().navigate(
                ExperienceFragmentDirections.actionExperienceFragment2ToExperienceDetailFragment(
                    experience
                )
            )
        }

        adapterExperience.setData(Portofolio.listDataExperience)

        with(binding.rvExperience) {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = adapterExperience
        }
    }
}