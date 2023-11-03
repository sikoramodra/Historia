<script>
	import { Link } from "svelte-routing";
</script>

<!-- <nav class="flex flex-row justify-around bg-DomCzerw p-6 text-2xl subpixel-antialiased font-bold text-slate-200">
    <Link to="/">Home</Link>
    <Link to="/library">Library</Link>
    <Link to="/projects">Projects</Link>
    <Link to="/search-site">Search Site</Link>
</nav> -->


<!-- Kminie nad innym navbarem -->
<nav class="fixed top-0 left-0 right-0 z-[60] px-8 h-20 text-black">
    <div class="font-semibold text-2xl flex flex-row items-center h-full">
        <div class="w-1/5">
            <Link to="/" class="text-left text-4xl px-4 font-bold">Home</Link>
        </div>
        <div class="w-3/5 text-left">
            <Link to="/library">Library</Link>
            <Link to="/projects" class="w-3/5 mx-4">Projects</Link>
        </div>
        <div class="w-1/5 text-right">
            <Link to="/search-site">Search Site <i class="fa-solid fa-magnifying-glass"></i></Link>
        </div>
    </div>
</nav>
