class BookViewModel : ViewModel() {
    private val apiService = ApiService.create()
    private val _books = MutableLiveData<List<VolumeInfo>>()
    val books: LiveData<List<VolumeInfo>> = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                val response = apiService.searchBooks(query)
                _books.value = response.items
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
} 