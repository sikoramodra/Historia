<script>
	export let data;

	const birthDateFormatted =
		data.birth_date === null ? null : `${data.birth_date.substring(8, 10)}.${data.birth_date.substring(5, 7)}.${data.birth_date.substring(0, 4)}`;
	const deathDateFormatted =
		data.death_date === null ? null : `${data.death_date.substring(8, 10)}.${data.death_date.substring(5, 7)}.${data.death_date.substring(0, 4)}`;
</script>

<!-- <div class="flex flex-col border border-gray-700 shadow-lg p-4 rounded-lg bg-gray-800 text-white h-min">
	<div class="text-center">
		<h1 class="font-bold text-lg lg:text-xl mb-2">{data.name}</h1>
		<div class="border-b border-gray-700 mb-2"></div>
	</div>
	<div class="flex flex-col lg:flex-row justify-between mb-4">
		<div>
			<h2 class="font-semibold text-md lg:text-lg mb-1">Other Names</h2>
			{#if data.other_names.length > 0}
				<div class="mt-2">
					{#each data.other_names.slice(0, 2) as otherName}
						<p class="text-sm lg:text-base">{otherName.length > 15 ? `${otherName.slice(0, 15)}...` : otherName}</p>
					{/each}
					{#if data.other_names.length > 2}
						<p class="text-sm lg:text-base">+ {data.other_names.length - 2} more</p>
					{/if}
				</div>
			{:else}
				<p class="text-sm lg:text-base">No other names</p>
			{/if}
		</div>
		<div class="mt-4 lg:mt-0 lg:ml-4">
			<h2 class="font-semibold text-md lg:text-lg mb-1">Code Names</h2>
			{#if data.code_names.length > 0}
				<div class="mt-2">
					{#each data.code_names.slice(0, 2) as codeName}
						<p class="text-sm lg:text-base">{codeName.length > 15 ? `${codeName.slice(0, 15)}...` : codeName}</p>
					{/each}
					{#if data.code_names.length > 2}
						<p class="text-sm lg:text-base">+ {data.code_names.length - 2} more</p>
					{/if}
				</div>
			{:else}
				<p class="text-sm lg:text-base">No code names</p>
			{/if}
		</div>
	</div>
	<div class="flex flex-col lg:flex-row justify-between mb-4">
		<div>
			<p class="text-gray-300"><span class="font-semibold">Birth Place:</span> {data.birth_place}</p>
			<p class="text-gray-300"><span class="font-semibold">Birth Date:</span> {birthDateFormatted}</p>
		</div>
		<div class="mt-4 lg:mt-0">
			<p class="text-gray-300"><span class="font-semibold">Death Place:</span> {data.death_place}</p>
			<p class="text-gray-300"><span class="font-semibold">Death Date:</span> {deathDateFormatted}</p>
		</div>
	</div>
</div> -->

<div class="flex flex-col text-gray-100 w-full bg-gray-800 p-6 rounded-lg shadow-lg border border-gray-700">
    <h1 class="font-bold text-3xl mb-2 text-center flex items-center justify-center border-b-2 border-gray-600 pb-2">
        {data.name}
    </h1>
    <p class="italic text-sm text-center pt-2">"{data.inscription}"</p>
    <div class="border-t border-gray-600 my-4"></div>
    <div class="grid grid-cols-1 gap-4">
        <div class="flex items-center">
            <svg class="w-6 h-6 mr-2" fill="none" stroke="currentColor" stroke-width="2" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" d="M3 4a1 1 0 011-1h16a1 1 0 011 1v16a1 1 0 01-1 1H4a1 1 0 01-1-1V4z"></path>
                <path stroke-linecap="round" stroke-linejoin="round" d="M8 2v4M16 2v4M3 10h18"></path>
            </svg>
            <p class="text-gray-400"><span class="font-semibold">Data urodzenia:</span> {birthDateFormatted}</p>
        </div>
        <div class="flex items-center">
            <svg class="w-6 h-6 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 20l4-16m2 16l4-16M6 9h12M4 15h12"></path>
            </svg>
            <p class="text-gray-400"><span class="font-semibold">Miejsce urodzenia:</span> {data.birth_place}</p>
        </div>
        <div class="flex items-center">
            <svg class="w-6 h-6 mr-2" fill="none" stroke="currentColor" stroke-width="2" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" d="M3 4a1 1 0 011-1h16a1 1 0 011 1v16a1 1 0 01-1 1H4a1 1 0 01-1-1V4z"></path>
                <path stroke-linecap="round" stroke-linejoin="round" d="M8 2v4M16 2v4M3 10h18"></path>
            </svg>
            <p class="text-gray-400"><span class="font-semibold">Data śmierci:</span> {deathDateFormatted}</p>
        </div>
        <div class="flex items-center">
            <svg class="w-6 h-6 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 20l4-16m2 16l4-16M6 9h12M4 15h12"></path>
            </svg>
            <p class="text-gray-400"><span class="font-semibold">Miejsce śmierci:</span> {data.death_place}</p>
        </div>
    </div>
    <div class="border-t border-gray-600 my-4"></div>
    <div>
        <h2 class="font-semibold text-md mb-1 flex items-center">
            <svg class="w-6 h-6 mr-2" fill="none" stroke="currentColor" stroke-width="2" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" d="M12 14l9-5-9-5-9 5 9 5z"></path>
                <path stroke-linecap="round" stroke-linejoin="round" d="M12 14l6.16-3.422a12.083 12.083 0 01.84 6.39c0 2.21-.684 4.253-1.84 5.972L12 20.5m0 0l-5.16 2.844C4.684 20.747 4 18.704 4 16.484a12.083 12.083 0 01.84-6.39L12 14z"></path>
            </svg>
            Cmentarz
        </h2>
        <p class="text-gray-400">{data.cemetery}, kw. {data.quarter}, rz. {data.row}, gr. {data.grave}</p>
    </div>
</div>


