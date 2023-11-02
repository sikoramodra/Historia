<script>
	import { Link } from "svelte-routing";
</script>

<nav class="flex flex-row justify-around mb-4 bg-DomCzerw p-6 text-2xl subpixel-antialiased font-bold text-slate-200">
    <Link to="/">Home</Link>
    <Link to="/library">Library</Link>
    <Link to="/news">News</Link>
    <Link to="/projects">Projects</Link>
    <Link to="/search-site">Search Site</Link>
</nav>