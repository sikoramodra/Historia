<script>
	import { Link } from "svelte-routing";
	import { mainColorText, mainColorBorder } from "../../stores/ColorStore.js";
	// import "../res/Logo poziom_ciemne tło_PNG.png";

	let NavColorText;
	let NavColorBorder;

	$: {
		NavColorText = $mainColorText;
		NavColorBorder = $mainColorBorder;
	}
</script>

<nav class="fixed top-0 left-0 right-0 z-[60] px-8 h-20 { NavColorText } ">
    <div class="font-semibold sm:text-base md:text-lg lg:text-xl xl:text-2xl 2xl:text-4xl text-sm flex flex-row items-center h-full w-full">
        <div class="w-1/5 min-w-fit h-full">
            <Link to="/" class="text-left font-bold h-full items-center flex justify-left"><img src="https://raw.githubusercontent.com/sikoramodra/Historia/stronka/Strona%20Internetowa/src/res/Logo%20poziom_ciemne%20tło_PNG.png" alt="Home" class="h-[2.5em] md:h-[2.5em] lg:h-[3em]" /></Link> <!-- text-3xl sm:text-4xl md:text-5xl lg:text-66xl xl:text-7xl 2xl:text-8xl -->
        </div>
        <div class="w-3/5 min-w-fit">
            <Link to="/library" class="w-1/2 ml-8 xl:ml-12 2xl:ml-16">Library</Link>
            <Link to="/projects" class="w-1/2 ml-8">Projects</Link>
        </div>
        <div class="w-1/5 text-right min-w-fit">
            <Link to="/search-site" class="border-2 p-2 rounded-lg { NavColorBorder }">Search Site <i class="fa-solid fa-magnifying-glass" /></Link>
        </div>
    </div>
</nav>

