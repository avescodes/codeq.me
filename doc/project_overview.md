Project Overview: codeq.me
==============================

Background
-----------

**Why was this project proposed?**

codeq.me is an attempt to sharpen my skills in Clojure's web-facing stack, using tools like Datomic, ClojureScript, Om and Pedestal-service.

**What business need/challenge are we solving?**

The desire to sharpen skills like:

* Systems design
* General Development in Clojure
* UI/UX
* DevOps

The system itself is codeq-as-a-service. 

**What are the pain points today?**

*On skills*: A general lack of familiarity with the tools, both incumbents and newcomers. Time away from frontend development has left previous skills there dull.

*On codeq*: The Codeq tool can be difficult to setup, requiring active installions of both codeq and Datomic, along with enough knowledge of Datomic and Codeq's schema to query it for any useful insights.

**What auxiliary goals/opportunities are we trying to accomplish or achieve?**

* Add another project to my portfoilio
* Provide value to those in the community
* Fodder for blog post

**How long is the solution expected to last?**

This project should freshen me up for the next 3-6 months, paving the way for larger, more complicated systems.

The tool itself should have a low enough maintenance overhead and cost to be run indefinitely.

**What constraints currently exist for the project?**

Primarily time.

Project statement
------------------

```
The (name of team) will
(build, develop, design, implement, etc.)
a (what) for (whom)
```

**The `Ryan` will design and implement a hosted version of Codeq with a number of built-in widgets for gaining insight about public GitHub repository.**


### Completion

This project will be be considered **successfully** completed when there is a hosted Codeq service that can import and analyze Clojure repositories from GitHub, with two widgets: one that exposes the tree of *symbols* in the project, and another that exposes the history of a *symbol* across *commits*.


### Win conditions

Everyone gets to pick three

| Condition             |   1   |   2   |   3   | Definition                   |
| :-------------------- | :---: | :---: | :---: | :--------------------------- |
| Schedule              |       |       |       |                              |
| Scope                 |       |       |    X  | Less is more–because this is a full-stack project, time and effort should be spread evenly across the project. |
| Quality               |       |    X  |       | Since this project is focussed on improving skills, effort should be made to *do it right*. |
| Budget                |       |       |       |                              |
| Customer satisfaction |       |       |       |                              |
| Teamwork/Learning     |   X   |       |       | At its core, this project is about learning the tools. Even failure to complete the project could still be considered a partial success. |

 1. Learning
 2. Quality
 3. Scope


### Scope

| In Scope                       | Out of Scope                             |
| :----------------------------: | :--------------------------------------: |
| UI/UX Design                   | Additional Widgets beyond core two       |
| Testing                        | Support for private repositories         |
| Application Hosting            | Must be Clojure project                  |
| Deployment                     | No other auth mechanisms                 |
| GitHub auth                    |                                          |
| Keep repos up to date          |
| Account/repository deletion    |



### Quality attributes and scenarios

Everyone gets to pick three
Definitions from [MSDN Architecture Guide](http://msdn.microsoft.com/en-us/library/ee658094.aspx)

| Attribute       |   1   |   2   |   3   | Definition                              |
| :-------------- | :---: | :---: | :---: | :-------------------------------------- |
| Scalability     |       |       |   X   | The ability of a system to handle increases in load without impact on the performance/runtime characteristics of the system |
| Security        |       |       |       | The capability of a system to prevent malicious or accidental actions outside of the designed usage, and to prevent disclosure or loss of information |
| Modifiability   |       |       |       | The ability of the system to undergo changes with a degree of ease |
| Maintainability |       |       |       | The ease of which the system is monitored, serviced, deployed, updated; Manageability |
| Reliability     |       |   X   |       | The ability of a system to remain operational over time, in the face of errors/defects/unknowns |
| Availability    |       |       |       | The proportion of time that the system is functional and working |
| Robustness      |       |       |       | The extent to which a software system can tolerate changes in its environment without intervention |
| Adaptability    |       |       |       | The extent to which a software system adapts to change in its environment without intervention |
| Usability       |   X   |       |       | Conformance to requirements, fitting [good design criteria](https://en.wikipedia.org/wiki/Heuristic_evaluation#Nielsen.27s_heuristics) |
| Performance     |       |       |       | Do you mean latency? throughput? etc? |

#### Quality attribute ranking

Usability > Reliability > Scalability

#### Scenarios // thresholds

* Usability
    * An authorized user should be able to add a new project in two clicks.
    * Users should be able to clearly understand where their new project is in the analysis pipeline. (Visibility of system status)
    * New analyzed contents should populate on a user's screen automatically.
    * (Aesthetic and minimalist design)
* Reliability
    * Failure of the codeq processing service should not alter the functioning of the web application and be accurately reported
* Scalability
    * Long-running or hung analyses should not affect the ability to conitnue analyzing other projects
    * In the event of high-load, the system should be able to increase processing power.

### Known risks and areas of unknown risks

* Multi-tenant codeq may be challenging.
* Integration with GitHub OAuth
* Codeq is an external tool that can take minutes to operate and may fail.
* Pedestal/Cljs/om is slightly new ground to break
* Very little experience implementing distributed systems


Metrics
-------

Metrics help us understand the project's context and progress.  They aid in
recognizing and identifying when project-wide problems occur.  Metrics provide
a baseline of objective data for making informed project-oriented decisions.

### Project metrics

 * Iteration burn up - points dev-completed within an iteration
 * Project burn down - total points remaining for the project (delivered to production)
 * Running tested features - cards or points delivered to production (not including defects or tasks)

### Software metrics

* Doc:code ratio
* Total source lines
* Cyclomatic complexity?
* Code coverage


### System metrics

* Latency to pick up new analyses
* Error rate of analyses
* Throughput of analyses

Extra
-----

### Special Conditions

 * Open source
    * No license restrictions, ideally project will be open sourced.
 * Additional technology restrictions?
     * Datomic
     * Om
     * Clojure/ClojureScript
     * Pedestal-service


### Baseline top-down estimations

Use [COCOMO with Monte Carlo simulation](http://csse.usc.edu/tools/COCOMO.php) to get an idea of where the project might end up.

*The entire project is [estimated](COCOMO.pdf) to be about **2.4 person-months** of effort*

### Baseline bottom-up estimations

Break down all major milestones into their individual tasks, and estimate effort (person-months) based on historical data

*In total, the project is estimated at **157 story points** of effort. At *4 points/day*, this is roughly **40 person-days** or **8 person-weeks**. This is similar to the top-down estimate of 2.4 person-months.*

Schedule
--------
*Caveat: if the per-phase assumptions are false, phases will need to be adjusted/adapted*

### Phase 1 - Widgets

* Build a minimal web service that can display codeq widgets populated with data from a single static Codeq analysis (of the Codeq codebase itself)
    * Basic pedestal-service - (1)
    * ClojureScript integration - (1)
    * Datomic connection/configuration - (2)
* Widgets to implement:
    * Symbol history widget
        * Markup for hierarchical display - (4)
        * Query to gather list of symbols - (4)
        * Function to tree-ify list of fully-qualified symbols by strata - (2)
        * Service endpoints - (2)
    * Symbols-tree history widget
        * Markup for display - (4)
        * Rigging up user interaction - (4)
        * Query for gathering discrete history of symbols - (4)
        * Cross-linking to external resources (e.g. "show me it in my repo") - (2)
        * Service endpoints - (2)
* Implement procedure for tracking software metrics - (4)

### Phase 2 - Web Interface

* Build web application around widgets
    * Template HTML - (2)
    * Basic styling - (2)
* Implement index of analyzed projects (a la TravisCI)
    * Index page - (2)
    * Service endpoint - (2)
* Staging deployment
    * Determine target - (2)
    * Deployment automation via X - (4)
    * Staged deployment (production vs. staging vs. development) - (2)

### Phase 3 - Authentication

* Implement user authentication via GitHub's OAuth
    * Markup for authentication status and initiation - (4)
    * User page - (2)
        * authorization - (2)
    * Endpoints for authentication flow - (2)
    * Credential persistence - (2)
* Implement index of user's eligible repositories (Clojure-lang and owned)
    * Gather list of user's repositories - (4)
    * Filter list by language - (1)
    * Cache list - (2)
    * Periodically re-fetch list - (2)
        * Delayed job system - (4)
    * Ability to refresh list - (1)
    * Markup for displaying repositories - (2)
* Delete Repository - (2)
* Delete User - (2)

### Phase 4 - Analysis

* Authenticated user's can request a public repositories they own is analyzed.
    * Markup for requesting analysis - (2)
    * Send a job to queue - (1)
* Implement a backend service to clone and analyze repositories.
    * Ability to clone repository - (4)
    * Ability to spawn codeq process to analyze project - (4)
    * Ability to kill long-running or hanged analyses - (2)
    * Ability to clean up repositories after use. - (1)
* Analysis service reports ongoing process and completion to service.
     * analysis service introspects on codeq process and register progress. - (8)
    * Markup for analysis status - (4)
    * Communicate status with client via websockets/long-polling. - (4)
* Implement periodic service to re-analyze repositories as new commits are added.
    * GitHub integration for post-commit hook. - (2)
    * Prioritization of analysis - (1)

### Phase 5 - Polish & Review

* Establish interface for display of collected system metrics. - (4)
* Implement system monitoring for services. - (8)
* Review and polish of UI design - (4)
* Add alerts for services under heavy, sustained load. - (4)
* Load testing - (8)
    * Possibly: auto-scaling - (8)
* Prepare release media blitz
    * Blog post - (2)
    * Twitter account - (1)
    * Announcements on Twitter/Reddit/HN/Lobste.rs - (1)
