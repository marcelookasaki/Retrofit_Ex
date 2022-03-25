package br.com.fourvrstudios.aula6_retrofitdemo.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import br.com.fourvrstudios.aula6_retrofitdemo.R
import br.com.fourvrstudios.aula6_retrofitdemo.ViewModels.RetrofitViewModel
import br.com.fourvrstudios.aula6_retrofitdemo.databinding.FragmentListaBinding

class ListaFragment : Fragment() {
    private val viewModel: RetrofitViewModel by activityViewModels()
    lateinit var binding: FragmentListaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista, container, false)
        binding.lifecycleOwner = this

        /* Exibe a lista de fotos de response */
        viewModel.response.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                it.forEach {
                    var item = "id ${it.id} - Title: ${it.title} - url: ${it.url} \n\n"
                    binding.txtRelatorio.append(item)
                }
            }
        })

        /* Exibe a foto de reqResponse */
        viewModel.reqResponse.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                var item = "id ${it.id} - Title: ${it.title} - url: ${it.url} \n\n"
                binding.txtRelatorio.append(item)
            }
        })

        return binding.root
    }
}