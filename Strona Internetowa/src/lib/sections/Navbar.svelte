<script>
    import { onMount } from "svelte";
    import Logo from "../../res/Logo_poziom_ciemne_tło_PNG.png";
// import "../../res/Logo poziom_ciemne tło_PNG.png"
    import { Link } from "svelte-routing";
    import { mainColorBorder, mainColorText } from "../../stores/ColorStore.js";

    let isScrolled = false;

    onMount(() => {
        window.addEventListener("scroll", handleScroll);

        return () => {
            window.removeEventListener("scroll", handleScroll);
        };
    });

    function handleScroll() {
        isScrolled = window.scrollY > 0;
    }

    let NavColorText;
    let NavColorBorder;

    $: {
        NavColorText = $mainColorText;
        NavColorBorder = $mainColorBorder;
    }
</script>

<nav class="fixed top-0 left-0 right-0 z-[60] px-4 sm:px-6 md:px-8 lg:px-10 xl:px-12 2xl:px-16 h-20 transition-colors  { NavColorText } { isScrolled ? 'scrolled' : '' }">
    <div class="font-semibold text-sm sm:text-base md:text-lg lg:text-xl xl:text-2xl 2xl:text-4xl flex flex-row items-center h-full">
        <div class="w-1/5 min-w-fit h-full">
            <Link to="/" class="text-left font-bold h-full items-center flex justify-left">
                <img src={Logo} alt="Home" class="h-12 md:h-14 lg:h-16" />
            </Link>
        </div>
        <div class="w-3/5 min-w-fit">
            <Link to="/library" class="w-1/2 ml-2 sm:ml-4 md:ml-6 lg:ml-8 xl:ml-10 2xl:ml-12">Articles</Link>
            <Link to="/projects" class="w-1/2 ml-2 sm:ml-4 md:ml-6 lg:ml-8 xl:ml-10 2xl:ml-12">Projects</Link>
        </div>
        <div class="w-1/5 text-right min-w-fit">
            <Link to="/search-site" class="border-2 p-2 rounded-lg { NavColorBorder }">Search Site <i class="fa-solid fa-magnifying-glass" /></Link>
        </div>
    </div>
</nav>

<style>
    .scrolled {
        background-color: rgb(2 6 23); /* Ustaw tutaj kolor tła po przewinięciu */
        
        
    }
    .scrolled, .fixed {
        transition: background-color 0.5s ease-in-out; /* Dodaj efekt ease in and out na 1 sekundę */
    }
</style>
