using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using MovieApi.Data;
using MovieApi.Models;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MovieApi.Controllers
{
    /// <summary>
    /// Controller for managing movies.
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class MoviesController : ControllerBase
    {
        private readonly MovieContext _context;

        /// <summary>
        /// Initializes a new instance of the <see cref="MoviesController"/> class.
        /// </summary>
        /// <param name="context">The movie context.</param>
        public MoviesController(MovieContext context)
        {
            _context = context;
        }

        /// <summary>
        /// Gets the list of movies.
        /// </summary>
        /// <returns>A list of movies.</returns>
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Movie>>> GetMovies()
        {
            return await _context.Movies.ToListAsync();
        }

        /// <summary>
        /// Gets a movie by ID.
        /// </summary>
        /// <param name="id">The movie ID.</param>
        /// <returns>The movie with the specified ID.</returns>
        [HttpGet("{id}")]
        public async Task<ActionResult<Movie>> GetMovie(int id)
        {
            var movie = await _context.Movies.FindAsync(id);

            if (movie == null)
            {
                return NotFound();
            }

            return movie;
        }

        /// <summary>
        /// Adds a new movie.
        /// </summary>
        /// <param name="movie">The movie to add.</param>
        /// <returns>The created movie.</returns>
        [HttpPost]
        public async Task<ActionResult<Movie>> PostMovie(Movie movie)
        {
            _context.Movies.Add(movie);
            await _context.SaveChangesAsync();

            return CreatedAtAction(nameof(GetMovie), new { id = movie.Id }, movie);
        }

        /// <summary>
        /// Updates an existing movie.
        /// </summary>
        /// <param name="id">The movie ID.</param>
        /// <param name="movie">The updated movie.</param>
        /// <returns>No content.</returns>
        [HttpPatch("{id}")]
        public async Task<IActionResult> PatchMovie(int id, Movie movie)
        {
            if (id != movie.Id)
            {
                return BadRequest();
            }

            _context.Entry(movie).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!MovieExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        /// <summary>
        /// Deletes a movie by ID.
        /// </summary>
        /// <param name="id">The movie ID.</param>
        /// <returns>No content.</returns>
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteMovie(int id)
        {
            var movie = await _context.Movies.FindAsync(id);
            if (movie == null)
            {
                return NotFound();
            }

            _context.Movies.Remove(movie);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        /// <summary>
        /// Checks if a movie exists by ID.
        /// </summary>
        /// <param name="id">The movie ID.</param>
        /// <returns>True if the movie exists, otherwise false.</returns>
        private bool MovieExists(int id)
        {
            return _context.Movies.Any(e => e.Id == id);
        }
    }
}