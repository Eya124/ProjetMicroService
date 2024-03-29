<?php

namespace App\Controller;

use App\Services\ReclamationService;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ReclamationController extends AbstractController
{
    private $reclamationService;

    public function __construct(ReclamationService $reclamationService)
    {
        $this->reclamationService = $reclamationService;
    }

    /**
     * @Route('/reclamations')
     */
    public function getAll(): Response
    {
        $notifications = $this->reclamationService->getAllReclamations();

        return $this->json($notifications, 200);
    }

    /**
     * @Route('/create')
     */
    public function createReclamation(Request $request): Response
    {
        $data = json_decode($request->getContent(), true);

        // Exemple de validation des données
        if (!isset($data['sujet']) || !isset($data['message']) || !isset($data['statut']) || !isset($data['userId']) || !isset($data['priorite']) || !isset($data['departement'])) {
            return $this->json(['error' => 'Missing or sujet or message or statut or userId or priorite or departement'], Response::HTTP_BAD_REQUEST);
        }

        $sujet = $data['sujet'];
        $message= $data['message'];
        $statut = $data['statut'];
        $userId = $data['userId'];
        $priorite = $data['priorite'];
        $departement = $data['departement'];

        $reclamation = $this->reclamationService->createReclamation($sujet, $message, $statut, $userId, $priorite, $departement);

        return $this->json($reclamation, Response::HTTP_CREATED);
    }

    /**
     * @Route("/update/{id}")
     */
    public function updateReclamation(Request $request, $id): Response
    {
        $data = json_decode($request->getContent(), true);

        // Recherche de la notification à mettre à jour
        $reclamation = $this->reclamationService->findReclamationById($id);

        if (!$reclamation) {
            return $this->json(['error' => 'Reclamation not found'], Response::HTTP_NOT_FOUND);
        }

        // Mettre à jour les champs
        if (isset($data['sujet'])) {
            $sujet = $data['sujet'];
        } else {
            $sujet = $reclamation->getSujet(); // Garder le message inchangé s'il n'est pas fourni dans la requête
        }
        if (isset($data['message'])) {
            $message = $data['message'];
        } else {
            $message = $reclamation->getMessage(); // Garder le message inchangé s'il n'est pas fourni dans la requête
        }
        if (isset($data['statut'])) {
            $statut = $data['statut'];
        } else {
            $statut = $reclamation->getStatut(); // Garder le message inchangé s'il n'est pas fourni dans la requête
        }
        if (isset($data['userId'])) {
            $userId = $data['userId'];
        } else {
            $userId = $reclamation->getUserId(); // Garder l'ID de l'utilisateur inchangé s'il n'est pas fourni dans la requête
        }
        if (isset($data['priorite'])) {
            $priorite = $data['priorite'];
        } else {
            $priorite = $reclamation->getPriorite(); // Garder l'ID de l'utilisateur inchangé s'il n'est pas fourni dans la requête
        }
        if (isset($data['departement'])) {
            $departement = $data['departement'];
        } else {
            $departement = $reclamation->getDepartement(); // Garder l'ID de l'utilisateur inchangé s'il n'est pas fourni dans la requête
        }

        // Enregistrer les modifications dans la base de données
        $this->reclamationService->updateReclamation($reclamation, $sujet, $message, $statut, $userId, $priorite, $departement);

        return $this->json($reclamation, Response::HTTP_OK);
    }

    /**
     * @Route("/delete/{id}")
     */
    public function deleteReclamation($id): Response
    {
        $reclamation = $this->reclamationService->findReclamationById($id);

        if (!$reclamation) {
            return $this->json(['error' => 'Reclamation not found'], Response::HTTP_NOT_FOUND);
        }

        $this->reclamationService->deleteReclamation($reclamation);

        return $this->json(['message' => 'Reclamation deleted'], Response::HTTP_OK);
    }

}